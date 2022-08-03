public class Game {
    Field field = new Field();
    Player player = new Player();
    Parser parser;
    String folder_levels = "";

    public Game() {
        folder_levels = "./Levels";
        parser = new Parser(folder_levels);
        parser.buildLevel(1, field, player);
    }
}
