package com.tomaspacheco.literalura.principal;

import java.util.*;
import java.util.stream.Collectors;

public class Principal {
    //ApiConsumption apiConsumption = new ApiConsumption();
    //DataConvertion dataConvertion = new DataConvertion();
    private final String BASE_URL = "https://www.omdbapi.com/";
    private final String API_KEY = "?apikey=bf49979c";
    private final String SEARCH_PARAMETER = "&t=";
    private final String SEASON_PARAMETER = "&Season=";
    //private List<Serie> series;
    //Optional<Serie> searchedSerie;

    Scanner keyboard = new Scanner(System.in);
    Boolean exit = false;
    String options = """
            1- Buscar series
            2- Buscar episodios
            3- Mostrar series buscadas
            4- Buscar serie por titulo
            5- Buscar Top 5 Series mejor evaluadas
            6- Buscar series por categoria
            7- Filtrar series por temporadas y evaluación
            8- Buscar episodios por nombre
            9- Buscar mejores 5 episodios de una serie

            0- Salir
            """;

    /*private List<SerieData> serieData = new ArrayList<>();*/

    /*private SerieRepository serieRepository;*/

    /*public Principal(SerieRepository repository) {
        this.serieRepository = repository;
    }*/

    public void showMenu() {

        while (!exit) {
            System.out.println("Selecciona una opción");
            System.out.println(options);
            var userSelection = keyboard.nextInt();
            keyboard.nextLine();
            switch (userSelection) {
                case 1:
                    System.out.println("Buscar serie");
                    //searchWebSerie();
                    break;
                case 2:
                    System.out.println("Buscar episodio");
                    //searchEpisodesBySerie();
                    break;
                case 3:
                    System.out.println("Mostrar series buscadas");
                    //showSearchedSeries();
                    break;
                case 4:
                    System.out.println("Buscar serie por titulo");
                    //searchSerieByTitle();
                    break;

                case 5:
                    System.out.println("Buscar Top 5 Series mejor evaluadas");
                    //searchTop5Series();
                    break;
                case 6:
                    System.out.println("Buscar serie por categoria");
                    //searchByCategory();
                    break;

                case 7:
                    System.out.println("Filtrar episodios por calificación de temporada y evaluación");
                    //filterSeriesBySeasonAndEvaluation();
                    break;
                case 8:
                    System.out.println("Buscar episodio por nombre");
                    //searchEpisodeByName();
                    break;
                case 9:
                    System.out.println("Buscar top 5 mejores episodios por serie");
                    //searchTop5EpisodesPerSerie();
                    break;


                case 0:
                    System.out.println("Saliendo de la app...");
                    exit = true;
            }
        }
    }

    /*private SerieData getSerieData() {
        System.out.println("Escribe el nombre de la serie que quieres buscar");
        //Search general data of the serie
        String serieName = keyboard.nextLine();
        var json = apiConsumption.getData(BASE_URL + API_KEY + SEARCH_PARAMETER + serieName.replace(" ", "+"));
        var data = dataConvertion.getData(json, SerieData.class);
        return data;
    }*/

    /*private void searchEpisodesBySerie() {

        showSearchedSeries();
        System.out.println("Escribe el el nombre de la serie de la cual quieres ver los episodios");
        var serieName = keyboard.nextLine();

        Optional<Serie> serie = series.stream()
                .filter(s -> s.getTitulo().toLowerCase().contains(serieName.toLowerCase()))
                .findFirst();

        if (serie.isPresent()) {
            var findedSerie = serie.get();
            List<SeasonData> seasons = new ArrayList<>();
            for (int i = 1; i <= findedSerie.getTotalTemporadas(); i++) {
                var json = apiConsumption.getData(BASE_URL + API_KEY + SEARCH_PARAMETER + findedSerie.getTitulo().replace(" ", "+") + SEASON_PARAMETER + i);
                var seasonData = dataConvertion.getData(json, SeasonData.class);
                seasons.add(seasonData);
            }
            seasons.forEach(System.out::println);
            List<Episode> episodes = seasons.stream()
                    .flatMap(d -> d.episodes().stream()
                            .map(e -> new Episode(d.season(), e)))
                    .collect(Collectors.toList());
            findedSerie.setEpisodes(episodes);
            serieRepository.save(findedSerie);
        } else {
            System.out.println("error");
        }

    }*/

    /*private void searchWebSerie() {
        SerieData newSerieData = getSerieData();
        Serie serie = new Serie(newSerieData);
        //Here we create the data in the DB
        serieRepository.save(serie);
        //serieData.add(newSerieData);
        System.out.println(newSerieData);
    }*/

    /*private void showSearchedSeries() {
        //We need to add a public constructor to the Object in this case Serie for make queries to DB with JPA
        series = serieRepository.findAll();
        series.stream()
                .sorted(Comparator.comparing(Serie::getGenero))
                .forEach(System.out::println);
    }*/

    /*private void searchSerieByTitle() {
        System.out.println("Escribe el titulo de la serie que deseas buscar");
        var serieName = keyboard.nextLine();

        searchedSerie = serieRepository.findByTituloContainsIgnoreCase(serieName);

        if (searchedSerie.isPresent()) {
            System.out.println("La serie buscada es: " + searchedSerie.get());
        } else {
            System.out.println("Serie no encontrada :(");
        }
    }*/

    /*private void searchTop5Series() {
        List<Serie> topSeries = serieRepository.findTop5ByOrderByEvaluacionDesc();
        topSeries.forEach(s ->
                System.out.println("Serie: " + s.getTitulo() + " Evaluacion: " + s.getEvaluacion()));
    }*/

    /*private void searchByCategory() {
        System.out.println("Escribe la categoria que quieres buscar");
        var categoryType = keyboard.nextLine();

        var category = Category.fromSpanish(categoryType);

        List<Serie> seriesPerCategory = serieRepository.findByGenero(category);

        System.out.println("Las series encontradas de la categoria: " + categoryType);
        seriesPerCategory.forEach(System.out::println);

    }*/

    /*private void filterSeriesBySeasonAndEvaluation() {
        System.out.println("¿Filtrar séries con cuántas temporadas? ");
        var totalTemporadas = keyboard.nextInt();
        keyboard.nextLine();
        System.out.println("¿Com evaluación apartir de cuál valor? ");
        var evaluacion = keyboard.nextDouble();
        keyboard.nextLine();
        List<Serie> filtroSeries = serieRepository.findByTotalTemporadasLessThanEqualAndEvaluacionGreaterThanEqual(totalTemporadas, evaluacion);
        System.out.println("*** Series filtradas ***");
        filtroSeries.forEach(s ->
                System.out.println(s.getTitulo() + "  - evaluacion: " + s.getEvaluacion()));
    }*/

    /*private void searchEpisodeByName() {
        System.out.println("Escribe el nombre o parte del nombre del episodio");
        var episodeNameToSearch = keyboard.nextLine();
        List<Episode> findedEpisodes = serieRepository.episodesPerName(episodeNameToSearch);
        findedEpisodes.forEach(e ->
                System.out.printf("Serie: %s Temporada: %s Episodio: %s Evaluación: %s\n", e.getSerie().getTitulo(), e.getSeason(), e.getEpisodeNumber(), e.getEvaluation()));
    }*/

    /*private void searchTop5EpisodesPerSerie() {
        searchSerieByTitle();

        if (searchedSerie.isPresent()) {
            Serie serie = searchedSerie.get();
            List<Episode> topEpisodes = serieRepository.top5BestEpisodes(serie);
            topEpisodes.forEach(e ->
                    System.out.printf("Serie: %s Temporada: %s Episodio: %s Evaluación: %s\n", e.getSerie().getTitulo(), e.getSeason(), e.getTitle(), e.getEvaluation()));
        }
    }*/
}