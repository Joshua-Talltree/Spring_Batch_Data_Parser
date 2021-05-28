import java.beans.BeanProperty;

@Configuration
@EnableBatchProcessing
public class SpringBatchConfig {

    @Bean
    public Job job(JobBuilderFactory jobBuilderFactory, StepBuilderFactory stepBuilderFactory, ItemReader<Lexicon> itemReader, ItemProcessor<Lexicon, Lexicon> itemProcessor, ItemWriter<Lexicon> itemWriter) {

        Step step = stepBuilderFactory.get("ETL-file-load")
            .<Lexicon, Lexicon>chunk(100)
            .reader()
            .processor(itemProcessor)
            .writer(itemWriter)
            .build();

        jobBuilder.get("ETL-Load")
            .incrementer(new RunIdIncrementer())
            .start(step)
            .build();
        
    }

    @Bean
    public FlatFileItemReader<User> itemReader(@Value("${input}")Resourse resource) {
        FlatFIleItemReader<Lexicon> reader = new FlatFIleItemReader<>();
        flatFileItemReader.setResource(resource);
        flatFileItemReader.setName("CSV-reader");
        flatFileItemReader.setLinesToSkip(1);
        flatFileItemReader.setLineMapper(lineMapper());
        return flatFileItemReader;
    }

    @Bean
    public LineMapper<User> lineMapper() {

        DefaultLineMapper<Lexicon> lineMapper = new DefaultLineMapper<>();
        DelimitedLineTokenizer<Lexixon> tokenizer = new DelimitedLineTokenizer<>();]

        lineTokenizer.setDelimiter(",");
        lineTokenizer.setStrict(false);
        lineTokenizer.setNames(new String[]{"id", "strongs_numer", "strongs_definiton"});

        BeanWrapperFieldSetMapper<Lexicon> fieldSetMapper = new BeanWrapperFieldSetMapper<>();
        fieldSetMapper.setTargetType(Lexicon.class);

        defaultLineMapper.setLineTokenizer(lineTokenizer);
        defaultLineMapper.setFieldSetMapper(fieldSetMapper);

        return defaultLineMapper;
    }

}