package scorpiomiku;

public class FilePath {
    private String inputTxtFileName = null;
    private String outputCodeFileName = null;
    private String outputMapFileName = null;

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
