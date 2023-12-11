Goal : The purpose of this individual assignment is to train a machine learning model parallely on ec2 instances for predicting wine quality on a publically available data and then use the trained model to predict the wine quality. 
Specifically, you will learn: 
(1) how to use Apache Spark to train an ML model in parallel on multiple EC2 instances; 
(2) how to use Spark’s MLlib to develop and use an ML model in the cloud; 
(3) How to use Docker to create a container for your ML model to simplify model deployment

Project also uses Docker to create a container for trained machine learning model to simplify deployments.

This project contains 2 main java source files:

modeltraining.java reads training dataset from S3 and trains model in parallel on EMR spark cluster. Once model is trained, it can be run on provided test data provided via S3. This program stores trained model in S3 bucket 

prediction.java program loads trained model and executes that model on given testdata file. 

Dockerfile: Dockerfile to create docker image and run container for simplified deployment.


Description :

1. How to create Spark cluster in AWS
      User can create spark cluster using EMR console provided by AWS. Please follow steps to create one with 4 ec2 instances
      1.  Create Key-Pair for EMR cluster using navigation EC2-> Network & Security -> Key-pairs. Use .pem as format. This will download {name of key pair}>.pem file. Keep it safe you will need that to do SSH to EC2 instances.
     2. Navigate to Amazon EMR console and then, navigate to clusters-> create cluster.
     3. User can also create spark cluster using aws cli command and cluster status should be 'Waiting' on successful cluster creation.

2. How to train ML model in Spark cluster with 4 ec2 instances in parallel
   1. Now when cluster is ready to accept jobs, to submit one you can either use step button to add steps or submit manually. To submit manually, Perform SSH to Master of cluster using below command:
                      ssh -i "ec2key.pem" <<User>>@<<Public IPv4 DNS>>
   2.  On successful login to master , change to root user by running command:
                      sudo su
   3. Submit job using following command:
                      spark-submit s3://wine-data-12/modeltraining.java
   4. You can trace status of this job in EMR UI application logs. Once status is succeded a test.model will be created in s3

3.  How to run trained ML model locally without docker.
     1. Clone the repository and Make sure you have spark environment setup locally for running this. 
     2. Place your testdata in 'csv' folder
        
4. Run ML model using Docker
     1. Install docker where you want to run this container
     2. A public image has been created and posted on DockerHub. Use the command Docker pull dfordeepika/awssparkwineapp to get the image on your machine.
     3. Place your testdata file in a folder (lets call it directory dirA) , which you will mount with docker container.
     4. run the docker



  
