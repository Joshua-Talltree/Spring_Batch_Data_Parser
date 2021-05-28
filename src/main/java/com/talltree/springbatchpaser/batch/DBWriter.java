@Component
public class DBWriter implements ItemWriter<Lexicon> {

    @Autowired
    private LexiconRepo lexiconRepo;

    @Override
    public void write (List<? extends Lexicon> lexicon) throws Exception {

        Systen.out.println("Data saved for lexicon: " + lexicon);
        lexiconRepo.save(lexicon);

    }

}