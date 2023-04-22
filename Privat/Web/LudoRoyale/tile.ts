

class Tile {
    private index : number;
    private brick : Brick | null;
    private image : HTMLImageElement;
    private home : boolean;

    constructor(index : number, image : HTMLImageElement) {
        this.index = index;
        this.image = image;
        this.brick = null;
    }
}