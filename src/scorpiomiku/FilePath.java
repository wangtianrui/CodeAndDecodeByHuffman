package scorpiomiku;

public class FilePath {
    private String inputTxtFileName = null;
    private String outputCodeFileName = null;
    private String outputMapFileName = null;


    public FilePath(String inputCodeFileName, String inputMapFileName) {
        this.inputCodeFileName = inputCodeFileName;
        this.inputMapFileName = inputMapFileName;
    }

    //private String outputTxtFileName = null ;
    private String inputCodeFileName = null ;
    private String inputMapFileName = null ;
    private String outPutFileName = null ;

    public String getInputCodeFileName() {
        return inputCodeFileName;
    }

    public void setInputCodeFileName(String inputCodeFileName) {
        this.inputCodeFileName = inputCodeFileName;
    }

    public String getInputMapFileName() {
        return inputMapFileName;
    }

    public void setInputMapFileName(String inputMapFileName) {
        this.inputMapFileName = inputMapFileName;
    }

    public String getOutPutFileName() {
        return outPutFileName;
    }

    public void setOutPutFileName(String outPutFileName) {
        this.outPutFileName = outPutFileName;
    }

    public String getInputTxtFileName() {
        return inputTxtFileName;
    }

    public void setInputTxtFileName(String inputTxtFileName) {
        this.inputTxtFileName = inputTxtFileName;
    }

    public String getOutputCodeFileName() {
        return outputCodeFileName;
    }

    public void setOutputCodeFileName(String outputCodeFileName) {
        this.outputCodeFileName = outputCodeFileName;
    }

    public String getOutputMapFileName() {
        return outputMapFileName;
    }

    public void setOutputMapFileName(String outputMapFileName) {
        this.outputMapFileName = outputMapFileName;
    }

    public FilePath(String inputTxtFileName, String outputCodeFileName, String outputMapFileName) {
        this.inputTxtFileName = inputTxtFileName;
        this.outputCodeFileName = outputCodeFileName;
        this.outputMapFileName = outputMapFileName;
    }

}
