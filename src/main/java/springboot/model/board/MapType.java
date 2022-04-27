package springboot.model.board;

import springboot.model.Complexity;

public enum MapType {
    // MAZE
    // RISKY
    // CHECKMATE
    // DIZZYDASH
    //
    CHECKMATE(Complexity.EASY, "maps/checkmate.png","maps/checkmate.json");

    final private String boardJSON;
    final private Complexity complexity;
    final private String pictureFile;

    MapType(Complexity complexity, String picture, String jsonLoad) {
        this.pictureFile = picture;
        this.complexity = complexity;
        this.boardJSON = jsonLoad;
    }

    public String getPictureFile() {
        return pictureFile;
    }

    public String getBoardJSON() {
        return boardJSON;
    }
}
