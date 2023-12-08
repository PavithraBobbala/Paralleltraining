import org.apache.spark.ml.regression.LinearRegression;
import org.apache.spark.ml.regression.LinearRegressionModel;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;

public class WineQualityModelTraining {
    public static void main(String[] args) {
        SparkSession spark = SparkSession.builder().appName("WineQualityModelTraining").getOrCreate();

        Dataset<Row> trainingData = spark.read().csv("C:\Users\PAVITRA PAVI\Downloads\TrainingDataset.csv")
            .toDF("fixed_acidity", "volatile_acidity", "citric_acid", "residual_sugar", "chlorides",
                "free_sulfur_dioxide", "total_sulfur_dioxide", "density", "pH", "sulphates", "alcohol", "quality");

        String[] featureCols = trainingData.columns();
        String labelCol = "quality";

        LinearRegression lr = new LinearRegression().setLabelCol(labelCol).setFeaturesCol("features");


        LinearRegressionModel lrModel = lr.fit(trainingData);

        lrModel.save("s3://your-s3-bucket/WineQualityModel");
    }
}
