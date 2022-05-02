package maps;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FilmesMap {

    private static Map<String, String> header;
    private static Map<String, Object> filme;
    private static Map<String, Object> categoria;
    private static Map<String, Object> categoria2;
    private static Map<String, Object> plataforma;
    private static List<Map<String, Object>> categorias;
    private static List<Map<String, Object>> plataformas;

    public static Map<String, String> getHeader() {
        return header;
    }

    public static Map<String, Object> getFilmes() {
        return filme;
    }

    public static Map<String, Object> getCategoria() {
        return categoria;
    }

    public static Map<String, Object> getCategorias2() {
        return categoria2;
    }

    public static Map<String, Object> getPlataforma() {
        return plataforma;
    }

    public static List<Map<String, Object>> getCategorias() {
        return categorias;
    }

    public static List<Map<String, Object>> getPlataformas() {
        return plataformas;
    }

    public static void initHeader(){
        header = new HashMap<>();
        header.put("Authorization", "Bearer" + "token");
    }

    public static void initCategorias(){
        categorias = new ArrayList<>();
        categoria = new HashMap<>();
        categoria2 = new HashMap<>();

        categoria.put("tipo", "AÃ§Ã£o");
        categoria.put("tipo", "ComÃ©dia");

        categorias.add(categoria);
        categorias.add(categoria2);

    }

    public static void initPlataforma(){
        plataforma = new HashMap<>();
        plataformas = new ArrayList<>();

        plataforma.put("nome", "NetFlix");
        plataformas.add(plataforma);
    }

    public static void initFilmes(){
        filme = new HashMap<>();
        filme.put("nome", "Alerta vermelho");
        filme.put("descricao", "Um alerta vermelho da Interpol é emitido e o agente do FBI John Hartley" +
                " assume o caso. Durante sua busca, ele se vê diante de um assalto ousado e é forçado" +
                " a se aliar ao maior ladrão de arte da história, Nolan Booth, para capturar a" +
                " ladra de arte mais procurada do mundo atualmente, Sarah Black.");
        filme.put("duracao", 1.35);
        filme.put("categoria",categorias);
        filme.put("platafromas",plataformas);

    }

    public  static  void initAll(){
        initHeader();
        initCategorias();
        initPlataforma();
        initFilmes();
    }
}
