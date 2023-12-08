Goal : The purpose of this individual assignment is to learn how to develop parallel machine learning (ML) applications in Amazon AWS cloud platform. Specifically, you will learn: 
(1) how to use Apache Spark to train an ML model in parallel on multiple EC2 instances; 
(2) how to use Spark’s MLlib to develop and use an ML model in the cloud; 
(3) How to use Docker to create a container for your ML model to simplify model deployment


Description : Building a wine quality prediction ML model in Spark over AWS involves several steps. Below is a high-level outline of the process in Java on Ubuntu Linux:

1. Setup AWS EC2 Instances:
     a. Launch 4 EC2 instances for parallel model training.
     b. Launch 1 EC2 instance for the prediction application.

2.  Install Spark on EC2 Instances:
      a. Connect to each EC2 instance and install Apache Spark.
      
3.  Upload Datasets to S3:
      a. Upload the 'TrainingDataset.csv' and 'ValidationDataset.csv' to an S3 bucket.

4.  Implement Spark Application for Model Training:
       a. Write a Spark application in Java using MLlib to train the wine quality prediction model.
       b. Read the training dataset from S3.
       c. Split the dataset for training and validation purposes.
       d. Train the model using parallel processing on the 4 EC2 instances.
       e. Tune hyperparameters using the validation dataset.

5.  Save the Trained Model:
       a. Save the trained model to a file or a storage system (e.g., HDFS or S3).

6.  Implement Spark Application for Prediction:
       a. Write a Spark application for prediction using the trained model.
       b. Read the TestDataset.csv (not provided, but use the validation dataset initially) from S3.
       c. Perform predictions using the trained model.

7.  Calculate F1 Score:
      a. Evaluate the performance of the prediction using the F1 score.
      b. Output the F1 score as the result.

8. Build Docker Container:
    a. Create a Dockerfile to package the prediction application.
    b. Include all necessary dependencies, the Spark application JAR, and the trained model.

9. Push Docker Image to a Registry:
    a. Build the Docker image.
     
        docker build -t wine-quality-prediction .

    b. Push the Docker image to a container registry (e.g., Amazon ECR).

        docker run -it wine-quality-prediction java -cp target/your-jar-file.jar WineQualityPrediction

10. Deploy Prediction Application:
    a. On the single EC2 instance, pull the Docker image.
    b. Run the Docker container for prediction.

11. Submit Predictions and F1 Score:
    a. Collect predictions from the prediction application.
    b. Calculate the F1 score using MLlib.
