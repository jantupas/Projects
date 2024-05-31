library(ggplot2)
library(rpart)
library(rpart.plot)
library(dplyr)
library(plotly)
library(caret)
library(partykit)

# Loading the dataset and initial viewing
housing_data <- read.csv(file = "house.csv", head = TRUE)

head(housing_data)
str(housing_data)
summary(housing_data) 
print(sum(is.na(housing_data)))

housing_data <- housing_data[, !names(housing_data) %in% c("X")]

head(housing_data)

# Exploratory data analysis

# Show distribution 
hist(housing_data$baths)
hist(housing_data$Area_in_Marla)
hist(housing_data$bedrooms)
hist(housing_data$price)

prop_count <- table(housing_data$property_type)
barplot(prop_count,
        main = "Distribution of Property Type",
        xlab = "Property Type",
        ylab = "Frequency",
        col = "skyblue",
        names.arg = as.character(names(prop_count)),
        cex.names = 0.5,
        ylim = c(0, max(prop_count+10000)))
        

text(x = barplot(prop_count, plot = FALSE),
     y = prop_count + 1,  
     labels = prop_count,
     pos = 3,  
     cex = 0.7,  
     col = "black")  


city_count <- table(housing_data$city)
barplot(city_count,
        main = "Distribution of City",
        xlab = "City",
        ylab = "Frequency",
        col = "skyblue",
        names.arg = as.character(names(city_count)),
        cex.names = 0.5,
        ylim = c(0, max(city_count) + 10000))

text(x = barplot(city_count, plot = FALSE),
     y = city_count + 1,  
     labels = city_count,
     pos = 3,  
     cex = 0.7,  
     col = "black")  

purpose_count <- table(housing_data$purpose)
barplot(purpose_count,
        main = "Distribution of Purpose",
        xlab = "Purpose",
        ylab = "Frequency",
        col = "skyblue",
        names.arg = as.character(names(purpose_count)),
        cex.names = 0.5,
        ylim = c(0, max(purpose_count) + 10000))

text(x = barplot(purpose_count, plot = FALSE),
     y = purpose_count + 1,  
     labels = purpose_count,
     pos = 3,  
     cex = 0.7,  
     col = "black")

# Show average price by city
df_summary <- housing_data %>%
  group_by(city) %>%
  summarise(mean_price = mean(price)) %>%
  arrange(desc(mean_price)) %>%
  head(10)

ggplot(df_summary, aes(x = reorder(city, -mean_price), y = mean_price, fill = city)) +
  geom_bar(stat = "identity", color = "black") +
  labs(x = "City Name", y = "Price", title = "Average Price by City") +
  theme_minimal() +
  theme(axis.text.x = element_text(angle = 45, hjust = 1)) +
  geom_text(aes(label = sprintf("$%.2f", mean_price)), vjust = -0.5, size = 3) +
  scale_fill_brewer(palette = "Set3")

# Show average price by property type
df_summary <- housing_data %>%
  group_by(property_type) %>%
  summarise(mean_price = mean(price)) %>%
  arrange(desc(mean_price)) %>%
  head(10)

ggplot(df_summary, aes(x = reorder(property_type, -mean_price), y = mean_price, fill = property_type)) +
  geom_bar(stat = "identity", color = "black") +
  labs(x = "Property Type", y = "Price", title = "Average Price by Property Type") +
  theme_minimal() +
  theme(axis.text.x = element_text(angle = 45, hjust = 1)) +
  geom_text(aes(label = sprintf("$%.2f", mean_price)), vjust = -0.5, size = 3) +
  scale_fill_brewer(palette = "Set3")

# Show city by ad posting
df_summary <- housing_data %>%
  group_by(city) %>%
  summarise(count = n()) %>%
  arrange(desc(count)) %>%
  head(15)

color_palette <- scales::brewer_pal(palette = "Set3")(length(unique(df_summary$city)))

ggplot(df_summary, aes(y = reorder(city, count), x = count, fill = city)) +
  geom_bar(stat = "identity", width = 0.8) +
  labs(title = "Which City Has More Ad Posting", x = "Count", y = "City") +
  theme_minimal() +
  scale_fill_manual(values = color_palette) +
  theme(axis.text.y = element_text(size = 9)) +
  theme(legend.position = "none") +
  geom_text(aes(label = count), hjust = -0.1, size = 3)

# Prepare the data
housing_data$property_type <- as.factor(housing_data$property_type)
housing_data$location <- as.factor(housing_data$location)
housing_data$city <- as.factor(housing_data$city)

head(housing_data)
# Splitting 80:20 ratio
set.seed(123)
split_index <- sample(1:nrow(housing_data), 0.8 * nrow(housing_data))
train_data <- housing_data[split_index, ]
test_data <- housing_data[-split_index, ]


# CART Decision Tree model
target <- "price"
formula = as.formula(paste(target, " ~ . "))
model <- rpart(formula, data = train_data, method = "anova")
summary(model)

predictions <- predict(model, newdata = test_data)

actual <- test_data[[target]]
head(actual)

# MAE
mae <- MAE(predictions, actual)
cat("Mean Absolute Error (MAE):", mae, "\n")

# MSE
mse <- mean((predictions - actual)^2)
cat("Mean Squared Error (MSE):", mse, "\n")

# R-Squared
rsquared <- 1 - sum((actual - predictions)^2) / sum((actual - mean(actual))^2)
cat("R-Squared:", rsquared, "\n")

# Scatterplot
plot(actual, predictions, main = "Actual vs. Predicted",
     xlab = "Actual", ylab = "Predicted")
abline(0, 1, col = "red")

# Residual Plot
residuals <- actual - predictions
plot(predictions, residuals, main = "Residual Plot",
     xlab = "Predicted Prices", ylab = "Residuals")
abline(h = 0, col = "red")  # Add a horizontal line at y = 0

# Residuals Distribution
hist(residuals, main = "Histogram of Residuals",
     xlab = "Residuals", col = "skyblue", border = "black")

# Tree Plot
ctree_model <- as.party(model)
plot(ctree_model)

# Hyperparameter Optimization
tuning_grid <- expand.grid(
  cp = seq(0.001, 0.1, by = 0.001)
)
tuning_grid <- expand.grid(
  cp = seq(0.001, 0.1, by = 0.001),
  minsplit = c(2, 5, 10),
  minbucket = c(1, 5, 10),
  maxdepth = c(5, 10, 15),
  surrogate = c(TRUE, FALSE)
)

model <- train(formula,
               data = train_data,
               method = "rpart",
               trControl = trainControl(method = "cv", number = 5),
               tuneGrid = tuning_grid)

# Print the results
print(model)

# Extract the best model
best_model <- model$finalModel

# Extract the best hyperparameters
best_hyperparameters <- model$bestTune
print(best_hyperparameters)
