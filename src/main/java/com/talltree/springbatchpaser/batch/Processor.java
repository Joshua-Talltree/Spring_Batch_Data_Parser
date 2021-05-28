@Component
public class Processor extends ItemProcessor<Lexicon, Lexicon> { 

    private static final Map<String, String> STRONGS_NUMBER = new Hashmap<>();

    public Processor() {
        STRONGS_NUMBER.put("G1", "Alpha");
        STRONGS_NUMBER.put("G2", "Aaron");
        STRONGS_NUMBER.put("G3", "Abaddon");
    }

    @Override
    public Lexicon process(Lexicon lexicon) throws Exception {
        String strongsNumber = lexicon.getStrongsNumber();
        String sNum = STONGS_NUMBER.get(strongsNumber);
        lexicon.setStrongsNumber(sNum);
        System.out.println(String.format("Converted from [%s] to [%s]", strongsNumber, sNum));
        return lexicon;
    }

}