install.packages("tidyverse")
library(tidyverse)

install.packages("ggplot2")
library(ggplot2)

bank_data <- read.csv(file = "bank-full.csv", head = TRUE, sep = ";")

head(bank_data)

hist(bank_data$age)
hist(bank_data$duration)
hist(bank_data$campaign)
hist(bank_data$previous)

job_counts <- table(bank_data$job)
barplot(job_counts,
        main = "Distribution of Jobs",
        xlab = "Job",
        ylab = "Frequency",
        col = "skyblue",
        names.arg = as.character(names(job_counts)),
        cex.names = 0.8)

marital_counts <- table(bank_data$marital)
barplot(marital_counts,
        main = "Distribution of Marital",
        xlab = "Marital",
        ylab = "Frequency",
        col = "skyblue",
        names.arg = as.character(names(marital_counts)),
        cex.names = 0.8)

education_counts <- table(bank_data$education)
barplot(education_counts,
        main = "Distribution of Education",
        xlab = "education",
        ylab = "Frequency",
        col = "skyblue",
        names.arg = as.character(names(education_counts)),
        cex.names = 0.8)

contact_counts <- table(bank_data$contact)
barplot(marital_counts,
        main = "Distribution of contact",
        xlab = "contact",
        ylab = "Frequency",
        col = "skyblue",
        names.arg = as.character(names(contact_counts)),
        cex.names = 0.8)

default_counts <- table(bank_data$default)
barplot(default_counts,
        main = "Distribution of contact",
        xlab = "default",
        ylab = "Frequency",
        col = "skyblue",
        names.arg = as.character(names(default_counts)),
        cex.names = 0.8)

housing_counts <- table(bank_data$housing)
barplot(housing_counts,
        main = "Distribution of housing",
        xlab = "housing",
        ylab = "Frequency",
        col = "skyblue",
        names.arg = as.character(names(housing_counts)),
        cex.names = 0.8)

loan_counts <- table(bank_data$loan)
barplot(loan_counts,
        main = "Distribution of loan",
        xlab = "loan",
        ylab = "Frequency",
        col = "skyblue",
        names.arg = as.character(names(loan_counts)),
        cex.names = 0.8)

y_counts <- table(bank_data$y)
barplot(y_counts,
        main = "Distribution of y",
        xlab = "y",
        ylab = "Frequency",
        col = "skyblue",
        names.arg = as.character(names(y_counts)),
        cex.names = 0.8)

selected_columns <- bank_data[, c("age","job","marital","education", "default","balance","housing","loan", "contact","duration","campaign","pdays","previous","poutcome", "y")]
final_data <- data.frame(selected_columns)
head(final_data)

str(final_data)

summary(final_data)

final_data$job <- as.factor(final_data$job)
final_data$marital <- as.factor(final_data$marital)
final_data$education <- as.factor(final_data$education)
final_data$contact <- as.factor(final_data$contact)
final_data$poutcome <- as.factor(final_data$poutcome)
final_data$y <- as.numeric(final_data$y == "yes")
final_data$default <- as.numeric(final_data$default == "yes")
final_data$housing <- as.numeric(final_data$housing == "yes")
final_data$loan <- as.numeric(final_data$loan == "yes")
head(final_data)

sum(is.na(final_data))

model <- lm(y ~ ., data = final_data)

summary(model)

final_data$predicted_prob <- predict(model, type = "response")

ggplot(final_data, aes(x = y, y = predicted)) +
  geom_point() +
  geom_smooth(method = "lm", se = FALSE, color = "blue") +
  labs(title = "Multiple Regression Chart",
       x = "Actual",
       y = "Predicted")
