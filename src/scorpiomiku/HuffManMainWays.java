package scorpiomiku;

public interface HuffManMainWays {
    public CodeAndMap encode(String string);

    public String decode(CodeAndMap mapOfEncode);
}
