//This example uses transfer learning from YOLOv2 pretrained model

package global.skymind.training.object_detection.AvocadoBananaDetector;

import org.bytedeco.javacv.Frame;
import org.bytedeco.opencv.opencv_core.Scalar;
import org.deeplearning4j.nn.graph.ComputationGraph;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.util.List;

import static org.bytedeco.opencv.helper.opencv_core.RGB;

///**
// * This is an example of a object detection using YOLOv2 architecture.
// * If no model exists, train a model using Transfer Learning, then validate with test set
// * If model exists, Validate model with test set and run real time inference on webcam frames.
// * This model can detect avocado and banana in a single frame or live webcam frames.
// * **/

public class AvocadoBananaDetector_YOLOv2 {
    private static final Logger log = LoggerFactory.getLogger(AvocadoBananaDetector_YOLOv2.class);
    private static int seed = 123;
    private static double detectionThreshold = 0.5;
    private static int nBoxes = 5;
    private static double lambdaNoObj = 0.5;
    private static double lambdaCoord = 5.0;
    private static double[][] priorBoxes = {{1, 3}, {2.5, 6}, {3, 4}, {3.5, 8}, {4, 9}};

    private static int batchSize = 2;
    private static int nEpochs = 40;
    private static double learningRate = 1e-4;
    private static int nClasses = 2;
    private static List<String> labels;

    private static File modelFilename = new File(System.getProperty("user.dir"), "generated-models/AvocadoBananaDetector_yolov2.zip");
    private static ComputationGraph model;
    private static Frame frame = null;
    private static final Scalar GREEN = RGB(0, 255.0, 0);
    private static final Scalar YELLOW = RGB(255, 255, 0);
    private static Scalar[] colormap = {GREEN, YELLOW};
    private static String labeltext = null;

    public static void main(String[] args) throws Exception {

        FruitDataSetIterator.setup();

        //        STEP 1 : Create iterators


        //        If model does not exist, train the model, else directly go to model evaluation and then run real time object detection inference.
//        if (modelFilename.exists()) {
        //        STEP 2 : Load trained model from previous execution
//            Nd4j.getRandom().setSeed(seed);
//            log.info("Load model...");
//            model = ModelSerializer.restoreComputationGraph();
//        } else {
//            Nd4j.getRandom().setSeed(seed);
//            ComputationGraph pretrained = null;
//            FineTuneConfiguration fineTuneConf = null;
//            INDArray priors = Nd4j.create();
        //     STEP 2 : Train the model using Transfer Learning
        //     STEP 2.1: Transfer Learning steps - Load TinyYOLO prebuilt model.
//            log.info("Build model...");
//            pretrained = (ComputationGraph) .builder().build().initPretrained();

        //     STEP 2.2: Transfer Learning steps - Model Configurations.
//            fineTuneConf = getFineTuneConfiguration();

        //     STEP 2.3: Transfer Learning steps - Modify prebuilt model's architecture
//            model = getNewComputationGraph(, , );
//            System.out.println(model.summary(InputType.convolutional(
//                    FruitDataSetIterator.yoloheight,
//                    FruitDataSetIterator.yolowidth,
//                    nClasses)));

        //     STEP 2.4: Training and Save model.
//            log.info("Train model...");
//            UIServer server = UIServer.getInstance();
//            StatsStorage storage = new InMemoryStatsStorage();
//            server.attach(storage);
//            model.setListeners(new ScoreIterationListener(1), new StatsListener(storage));
//
//            for (int i = 1; i < nEpochs+1; i++) {
//                trainIter.reset();
//                while (trainIter.hasNext()) {
//                    model.(.next());
//                }
//                log.info("*** Completed epoch {} ***", i);
//            }
//            ModelSerializer.(, modelFilename, true);
//            System.out.println("Model saved.");
//        }
        //     STEP 3: Evaluate the model's accuracy by using the test iterator.
//        OfflineValidationWithTestDataset(testIter);
        //     STEP 4: Inference the model and process the webcam stream and make predictions.
//        doInference();
//    }
//
//    private static ComputationGraph getNewComputationGraph(ComputationGraph pretrained, INDArray priors, FineTuneConfiguration fineTuneConf) {
//
//        return new TransferLearning.GraphBuilder(pretrained)
//                .fineTuneConfiguration(fineTuneConf)
//                .removeVertexKeepConnections("conv2d_23")
//                .removeVertexKeepConnections("outputs")
//                .addLayer("conv2d_23",
//                        new ConvolutionLayer.Builder(1, 1)
//                                .nIn(1024)
//                                .nOut()
//                                .stride(1, 1)
//                                .convolutionMode(ConvolutionMode.Same)
//                                .weightInit(WeightInit.XAVIER)
//                                .activation(Activation.IDENTITY)
//                                .build(),
//                        "leaky_re_lu_22")
//                .addLayer("outputs",
//                        new .Builder()
//                                .lambdaNoObj(lambdaNoObj)
//                                .lambdaCoord(lambdaCoord)
//                                .boundingBoxPriors(priors.castTo(DataType.FLOAT))
//                                .build(),
//                        "conv2d_23")
//                .setOutputs("outputs")
//                .build();
//    }
//
//    private static FineTuneConfiguration getFineTuneConfiguration() {
//
//        return new FineTuneConfiguration.Builder()
//                .seed(seed)
//                .optimizationAlgo(OptimizationAlgorithm.STOCHASTIC_GRADIENT_DESCENT)
//                .gradientNormalization(GradientNormalization.RenormalizeL2PerLayer)
//                .gradientNormalizationThreshold(1.0)
//                .updater(new Adam.Builder().learningRate(learningRate).build())
//                .l2(0.00001)
//                .activation(Activation.IDENTITY)
//                .trainingWorkspaceMode(WorkspaceMode.ENABLED)
//                .inferenceWorkspaceMode(WorkspaceMode.ENABLED)
//                .build();
//    }
//
////    Evaluate visually the performance of the trained object detection model
//    private static void OfflineValidationWithTestDataset(RecordReaderDataSetIterator test)throws InterruptedException{
//        NativeImageLoader imageLoader = new NativeImageLoader();
//        CanvasFrame canvas = new CanvasFrame("Validate Test Dataset");
//        OpenCVFrameConverter.ToMat converter = new OpenCVFrameConverter.ToMat();
//        org.deeplearning4j.nn.layers.objdetect.Yolo2OutputLayer yout = (org.deeplearning4j.nn.layers.objdetect.Yolo2OutputLayer)model.getOutputLayer(0);
//        Mat convertedMat = new Mat();
//        Mat convertedMat_big = new Mat();
//
//        while (test.hasNext() && canvas.isVisible()) {
//
//            org.nd4j.linalg.dataset.DataSet ds = test.next();
//            INDArray features = ds.getFeatures();
//            INDArray results = model.outputSingle(features);
//            List<DetectedObject> objs = yout.getPredictedObjects(results, detectionThreshold);
//            List<DetectedObject> objects = NonMaxSuppression.getObjects(objs);
//
//            Mat mat = imageLoader.asMat(features);
//            mat.convertTo(convertedMat, CV_8U, 255, 0);
//            int w = mat.cols() * 2;
//            int h = mat.rows() * 2;
//            resize(convertedMat,convertedMat_big, new Size(w, h));
//
//            for (DetectedObject obj : objects) {
//                double[] xy1 = obj.getTopLeftXY();
//                double[] xy2 = obj.getBottomRightXY();
//                String label = labels.get(obj.getPredictedClass());
//                int x1 = (int) Math.round(w * xy1[0] / FruitDataSetIterator.gridWidth);
//                int y1 = (int) Math.round(h * xy1[1] / FruitDataSetIterator.gridHeight);
//                int x2 = (int) Math.round(w * xy2[0] / FruitDataSetIterator.gridWidth);
//                int y2 = (int) Math.round(h * xy2[1] / FruitDataSetIterator.gridHeight);
//                //Draw bounding box
//                rectangle(convertedMat_big, new Point(x1, y1), new Point(x2, y2), colormap[obj.getPredictedClass()], 2, 0, 0);
//                //Display label text
//                labeltext =label+" "+(Math.round(obj.getConfidence()*100.0)/100.0)*100.0 +"%";
//                int[] baseline ={0};
//                Size textSize=getTextSize(labeltext, FONT_HERSHEY_DUPLEX, 1,1,baseline);
//                rectangle(convertedMat_big, new Point(x1 + 2, y2 - 2), new Point(x1 + 2+textSize.get(0), y2 - 2-textSize.get(1)), colormap[obj.getPredictedClass()], FILLED,0,0);
//                putText(convertedMat_big, labeltext, new Point(x1 + 2, y2 - 2), FONT_HERSHEY_DUPLEX, 1, RGB(0,0,0));
//            }
//            canvas.showImage(converter.convert(convertedMat_big));
//            canvas.waitKey();
//        }
//        canvas.dispose();
//    }
//
//    // Stream video frames from Webcam and run them through YOLOv2 model and get predictions
//    private static void doInference(){
//
//        String cameraPos = "front";
//        int cameraNum = 0;
//        Thread thread = null;
//        NativeImageLoader loader = new NativeImageLoader(
//                FruitDataSetIterator.yolowidth,
//                FruitDataSetIterator.yoloheight,
//                3,
//                new ColorConversionTransform(COLOR_BGR2RGB));
//        ImagePreProcessingScaler scaler = new ImagePreProcessingScaler(0, 1);
//
//        if( !cameraPos.equals("front") && !cameraPos.equals("back") )
//        {
//            try {
//                throw new Exception("Unknown argument for camera position. Choose between front and back");
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
//
//        FrameGrabber grabber = null;
//        try {
//            grabber = FrameGrabber.createDefault(cameraNum);
//        } catch (FrameGrabber.Exception e) {
//            e.printStackTrace();
//        }
//        OpenCVFrameConverter.ToMat converter = new OpenCVFrameConverter.ToMat();
//
//        try {
//            grabber.start();
//        } catch (FrameGrabber.Exception e) {
//            e.printStackTrace();
//        }
//
//        String winName = "Object Detection";
//        CanvasFrame canvas = new CanvasFrame(winName);
//
//        int w = grabber.getImageWidth();
//        int h = grabber.getImageHeight();
//
//
//        canvas.setCanvasSize(w, h);
//        while (true)
//        {
//            try {
//                frame = grabber.grab();
//            } catch (FrameGrabber.Exception e) {
//                e.printStackTrace();
//            }
//
//            //if a thread is null, create new thread
//            if (thread == null)
//            {
//                thread = new Thread(() ->
//                {
//                    while (frame != null)
//                    {
//                        try
//                        {
//                            Mat rawImage = new Mat();
//
//                            //Flip the camera if opening front camera
//                            if(cameraPos.equals("front"))
//                            {
//                                Mat inputImage = converter.convert(frame);
//                                flip(inputImage, rawImage, 1);
//                            }
//                            else
//                            {
//                                rawImage = converter.convert(frame);
//                            }
//
//                            Mat resizeImage = new Mat();
//                            resize(rawImage, resizeImage, new Size(FruitDataSetIterator.yolowidth, FruitDataSetIterator.yoloheight));
//
//                            INDArray inputImage = loader.asMatrix(resizeImage);
//                            scaler.transform(inputImage);
//                            INDArray outputs = model.outputSingle(inputImage);
//                            org.deeplearning4j.nn.layers.objdetect.Yolo2OutputLayer yout = (org.deeplearning4j.nn.layers.objdetect.Yolo2OutputLayer)model.getOutputLayer(0);
//                            List<DetectedObject> objs = yout.getPredictedObjects(outputs, detectionThreshold);
//                            List<DetectedObject> objects = NonMaxSuppression.getObjects(objs);
//
//                            for (DetectedObject obj : objects) {
//
//                                double[] xy1 = obj.getTopLeftXY();
//                                double[] xy2 = obj.getBottomRightXY();
//                                String label = labels.get(obj.getPredictedClass());
//                                int x1 = (int) Math.round(w * xy1[0] / FruitDataSetIterator.gridWidth);
//                                int y1 = (int) Math.round(h * xy1[1] / FruitDataSetIterator.gridHeight);
//                                int x2 = (int) Math.round(w * xy2[0] / FruitDataSetIterator.gridWidth);
//                                int y2 = (int) Math.round(h * xy2[1] / FruitDataSetIterator.gridHeight);
//                                //Draw bounding box
//                                rectangle(rawImage, new Point(x1, y1), new Point(x2, y2), colormap[obj.getPredictedClass()], 2, 0, 0);
//                                //Display label text
//                                labeltext =label+" "+(Math.round(obj.getConfidence()*100.0)/100.0)*100.0 +"%";
//                                int[] baseline ={0};
//                                Size textSize=getTextSize(labeltext, FONT_HERSHEY_DUPLEX, 1,1,baseline);
//                                rectangle(rawImage, new Point(x1 + 2, y2 - 2), new Point(x1 + 2+textSize.get(0), y2 - 2-textSize.get(1)), colormap[obj.getPredictedClass()], FILLED,0,0);
//                                putText(rawImage, labeltext, new Point(x1 + 2, y2 - 2), FONT_HERSHEY_DUPLEX, 1, RGB(0,0,0));
//                            }
//                            canvas.showImage(converter.convert(rawImage));
//                        }
//                        catch (Exception e)
//                        {
//                            throw new RuntimeException(e);
//                        }
//                    }
//                });
//                thread.start();
//            }
//
//            KeyEvent t = null;
//            try {
//                t = canvas.waitKey(33);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//
//            if ((t != null) && (t.getKeyCode() == KeyEvent.VK_Q)) {
//                break;
//            }
//        }
    }
}



