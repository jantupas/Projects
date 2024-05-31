library(data.table)
library(ggplot2)
library(rpart)
library(rpart.plot)



flight_data <- fread(file = "Data_Train.csv", head = TRUE)

head(flight_data)

str(flight_data)

summary(flight_data)

#Visualization
options(repr.plot.width = 8, repr.plot.height = 4)

par(mar = c(3, 4, 4, 0.5)) 

airline_counts <- table(flight_data$Airline)
print(airline_counts)
barplot(airline_counts,
          main = "Distribution of Airline",
          xlab = "Airline",
          ylab = "Frequency",
          col = "skyblue",
          names.arg = as.character(names(airline_counts)),
          cex.names = 0.5)

source_counts <- table(flight_data$Source)
print(source_counts)
barplot(source_counts,
        main = "Distribution of Source",
        xlab = "Source",
        ylab = "Frequency",
        col = "skyblue",
        names.arg = as.character(names(source_counts)),
        cex.names = 1)

dest_counts <- table(flight_data$Destination)
print(dest_counts)
barplot(dest_counts,
        main = "Distribution of Destination",
        xlab = "Destination",
        ylab = "Frequency",
        col = "skyblue",
        names.arg = as.character(names(dest_counts)),
        cex.names = 1)

route_counts <- table(flight_data$Route)
print(route_counts)
unique_route <- unique(flight_data$Route)
print(unique_route)  
len_route <- length(unique_route)  
print(len_route)

stop_counts <- table(flight_data$Total_Stops)
print(stop_counts)
barplot(stop_counts,
        main = "Distribution of Total Stops",
        xlab = "Total Stops",
        ylab = "Frequency",
        col = "skyblue",
        names.arg = as.character(names(stop_counts)),
        cex.names = 1)

info_counts <- table(flight_data$Additional_Info)
print(info_counts)
barplot(info_counts,
        main = "Distribution of Additional Info",
        xlab = "Additional Info",
        ylab = "Frequency",
        col = "skyblue",
        names.arg = as.character(names(info_counts)),
        cex.names = 0.5)

ggplot(flight_data, aes(x = Airline, y = Price)) +
  geom_boxplot(fill = "skyblue", color = "blue") +
  labs(title = "Boxplot of Ticket Prices by Airline",
       x = "Airline",
       y = "Ticket Price") + 
        theme(axis.text = element_text(size = 7))

ggplot(flight_data, aes(x = Source, y = Price)) +
  geom_boxplot(fill = "skyblue", color = "blue") +
  labs(title = "Boxplot of Ticket Prices by Source",
       x = "Source",
       y = "Ticket Price") + 
  theme(axis.text = element_text(size = 7))

ggplot(flight_data, aes(x = Destination, y = Price)) +
  geom_boxplot(fill = "skyblue", color = "blue") +
  labs(title = "Boxplot of Ticket Prices by Destination",
       x = "Destination",
       y = "Ticket Price") + 
  theme(axis.text = element_text(size = 7))

ggplot(flight_data, aes(x = Total_Stops, y = Price)) +
  geom_boxplot(fill = "skyblue", color = "blue") +
  labs(title = "Boxplot of Ticket Prices by Total Stops",
       x = "Total Stops",
       y = "Ticket Price") + 
  theme(axis.text = element_text(size = 7))

ggplot(flight_data, aes(x = Additional_Info, y = Price)) +
  geom_boxplot(fill = "skyblue", color = "blue") +
  labs(title = "Boxplot of Ticket Prices by Additional Info",
       x = "Additional Info",
       y = "Ticket Price") + 
  theme(axis.text = element_text(size = 7))





# Check for missing values
print(sum(is.na(flight_data)))

# Convert categorical variables to factors
flight_data$Airline <- as.factor(flight_data$Airline)
flight_data$Source <- as.factor(flight_data$Source)
flight_data$Destination <- as.factor(flight_data$Destination)
flight_data$Total_Stops <- as.factor(flight_data$Total_Stops)
flight_data$Additional_Info <- as.factor(flight_data$Additional_Info)
flight_data$Route <- as.factor(flight_data$Route)
flight_data$Duration <- as.factor(flight_data$Duration)



head(flight_data)


# Build a multiple regression model
model <- lm(Price ~ Airline + Source + Destination + Total_Stops +
              Additional_Info, data = flight_data)

summary(model)


plot(model)

predictions <- predict(model, newdata = flight_data)

# Create a data frame with actual and predicted values
result_df <- data.frame(Actual = flight_data$Price, Predicted = predictions)


# Create a scatter plot of Actual vs. Predicted values
ggplot(result_df, aes(x = Actual, y = Predicted)) +
  geom_point() +
  geom_smooth(method = "lm", se = FALSE, color = "blue") +
  labs(title = "Actual vs. Predicted Values",
       x = "Actual Price",
       y = "Predicted Price")
  