import org.apache.spark.ml.PipelineModel;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;

public class WineQualityPrediction {
    public static void main(String[] args) {
        SparkSession spark = SparkSession.builder().appName("WineQualityPrediction").getOrCreate();

        
        Dataset<Row> validationData = spark.read().csv("C:\Users\PAVITRA PAVI\Downloads\ValidationDataset.csv")
            .toDF("fixed_acidity", "volatile_acidity", "citric_acid", "residual_sugar", "chlorides",
                "free_sulfur_dioxide", "total_sulfur_dioxide", "density", "pH", "sulphates", "alcohol", "quality");

       PipelineModel model = PipelineModel.load("s3://your-s3-bucket/WineQualityModel");

        Dataset<Row> predictions = model.transform(validationData);

        predictions.show();
    }
}
