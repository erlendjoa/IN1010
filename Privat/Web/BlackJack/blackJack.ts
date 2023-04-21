

class Card {
    public image: string;
    public value: number;

    constructor(image: string, value: number) {
        this.image = image;
        this.value = value;
    }
}

class Player {
    public ids: HTMLImageElement[];
    private scoreId: HTMLHeadingElement;
    public hand: Card[];
    public score: number;

    constructor(ids: HTMLImageElement[], scoreId: HTMLHeadingElement) {
        this.ids = ids;
        this.scoreId = scoreId;
        this.hand = [];
        this.score = 0;
    }

    addCard(newCard: Card) {
        this.hand.push(newCard);
        this.updateCards();
    }

    revealCard(i: number) {
        // Set index id image to be hand image; Add to this.score;
        setTimeout(() => {
            this.ids[i].src = this.hand[i].image;
            this.scoreId.textContent = (this.score + this.hand[i].value).toString();
            this.scoreId.style.visibility = "visible";
        }, 1000);
    }

    updateCards() {
        let tempScore: number = 0;
        let tempHand: Card[] = [];

        for (let i = 0; i < this.hand.length; i++) {
            let currentId: HTMLImageElement = this.ids[i];
            let currentCard: Card = this.hand[i];
            currentId.src = currentCard.image; // Set current id to be the card id
            if (currentId.style.display = "hidden") {   // IF display == hidden:   WORKING??????
                currentId.style.border = "3px soild black"; // Set black border
                currentId.style.display = "block";  // Set visible;
            }
            tempHand.push(currentCard);
            tempScore += currentCard.value;
        }
        this.hand = tempHand;
        this.score = tempScore;
        this.scoreId.textContent = this.score.toString();
    }
}

class Game {
    private user: Player;
    private dealer: Player;
    private deck: Card[];

    constructor() {

        // Assing user and dealer ids;
        let userIds: HTMLImageElement[] = [];
        let dealerIds: HTMLImageElement[] = [];
        for (let i = 0; i < 8; i++) {
            userIds.push(document.getElementById("ciu" + i.toString())! as HTMLImageElement);
            dealerIds.push(document.getElementById("cid" + i.toString())! as HTMLImageElement);
        }       
        // Create and fill deck;
        this.deck = [];
        let typeArr: string[] = ["club", "heart", "spade", "diamond"];
        let valueArr: number[] = [11,2,3,4,5,6,7,8,9,10,10,10,10];
        for (let i = 0; i < 4; i++) {
            for (let j = 1; j < 14; j++) {
                this.deck.push(new Card("Assets/" + typeArr[i] + j.toString() + ".jpg", valueArr[j-1]));
            }
        }
        // Create players and assign cards;
        this.user = new Player(userIds, document.getElementById("playerScore")! as HTMLHeadingElement);
        this.dealer = new Player(userIds, document.getElementById("playerScore")! as HTMLHeadingElement);
        this.user.addCard(this.deck.splice(Math.floor(Math.random() * this.deck.length), 1)[0]);
        this.user.addCard(this.deck.splice(Math.floor(Math.random() * this.deck.length), 1)[0]);
        this.dealer.addCard(this.deck.splice(Math.floor(Math.random() * this.deck.length), 1)[0]);
        this.dealer.addCard(this.deck.splice(Math.floor(Math.random() * this.deck.length), 1)[0]);

        // Hide dealers card and score.
        dealerIds[0].src = "Assets/cardBack.jpg";
        dealerIds[1].src = "Assets/cardBack.jpg";
        (document.getElementById("dealerScore") as HTMLElement).style.visibility = "hidden";

        console.log(this.user.hand);
        console.log(this.dealer.hand);
    }

    addCardFromButton() {
        this.user.addCard(this.deck.splice(Math.floor(Math.random() * this.deck.length), 1)[0]);
    }

    lockInn() {
        // Hide the lockInn and addCard buttons;
        document.getElementById("lockInn")!.style.visibility = "hidden";
        document.getElementById("addCardButton")!.style.display = "none";
        // Reveal both dealer cards;
        this.dealer.revealCard(0);
        this.dealer.revealCard(1);
        this.dealerAddRest();
    }

    switchAceFromButton(i: number) {
        if (this.user.hand[i].value == 11) {
            this.user.hand[i].value = 1;
            this.user.ids[i].style.border = "3px solid yellow";
            this.user.updateCards();
        }
        else if (this.user.hand[i].value == 1) {
            this.user.hand[i].value = 11;
            this.user.ids[i].style.border = "3px solid black";
            this.user.updateCards();
        }
    }

    dealerAddRest() {
        if (this.user.score == 21) return true;

        if (this.user.score > 21) return false;

        if (this.dealer.hand[0].value == 11 && this.dealer.hand[1].value == 11) {
            this.switchAce(this.dealer, this.dealer.hand[0], 0);
            this.dealerAddRest(); 
        }
        if (this.dealer.score >= this.user.score) return false;

        while (this.dealer.score < 17 && this.dealer.score < this.user.score) {
            this.dealer.addCard(this.deck[Math.floor(Math.random() * (this.deck.length-1 - 0 + 1))]);
        }
        if (this.dealer.score < this.user.score || this.dealer.score > 21) {
            for (let i = 0; i < this.dealer.hand.length; i++) {
                if (this.dealer.hand[i].value == 11) {
                    this.switchAce(this.dealer, this.dealer.hand[i], i);
                    this.dealerAddRest();
                }
            }  
        }
        if (this.dealer.score >= this.user.score && this.dealer.score <= 21) return false;
        
        return true;  
    }   

    switchAce(player: Player, ace: Card, i: number) {
        ace.value = 1;
        player.ids[i].style.border = "3px solid yellow";
        player.updateCards();
    }
}

const game = new Game();