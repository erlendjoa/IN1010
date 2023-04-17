

class Card {
    constructor(image, value) {
        this.image = image;
        this.value = value;
    }
    getImage() {
        return this.image;
    }
    getValue() {
        return this.value;
    }
}

class Player {
    constructor(ids, scoreId) {
        this.ids = ids;  // [8] of id`s.
        this.scoreId = scoreId;
        this.hand = [];
        this.score = 0;
    }
    addCard(newCard) {
        this.hand.push(newCard);
        console.log("Added " + newCard.getImage() + "with a value of " + newCard.value);
        this.updateCards();
    }
    updateCards() {
        let tempScore = 0;
        let tempHand = [];
        for (i = 0; i < this.hand.length; i++) {
            if (i < this.hand.length) {
                this.ids[i].src = this.hand[i].getImage();
                tempHand.push(this.hand[i]);
                tempScore += this.hand[i].value;
            } else {
                if (this.ids[i].complete) {
                    this.ids[i].removeChild(element.querySelector("img[src='path/to/image.png']"));
                }
            }
        }
        this.hand = tempHand;
        this.score = tempScore;
        this.scoreId.textContent = this.score;
    }
    resetCards() {
        this.hand = [];
        this.score = 0;
        this.updateCards();
    }
}

// Get dealer and user Ids.
dealerScoreId = document.getElementById("dealerScore");
userScoreId = document.getElementById("playerScore");
dealerIds = [];
userIds = [];
for (i = 0; i < 8; i++) {
    dealerIds.push(document.getElementById("cid" + i));
    userIds.push(document.getElementById("ciu" + i));
}

// Create and push new Cards to deck[].
deck = [];  
typeArr = ["club", "heart", "spade", "diamond"];
valueArr = [1,2,3,4,5,6,7,8,9,10,10,10,10];
for (i = 0; i < 4; i++) {
    for (j = 0; j < 13; j++) {
        deck.push(new Card("Assets/" + typeArr[i] + j + ".jpg", valueArr[j]));
    }
}


user = new Player(userIds, userScoreId);
dealer = new Player(dealerIds, dealerScoreId);
user.addCard(deck[Math.floor(Math.random() * (deck.length-1 - 0 + 1))]);
console.log("Fullført 1");
user.addCard(deck[Math.floor(Math.random() * (deck.length-1 - 0 + 1))]);
console.log("Fullført 1");
dealer.addCard(deck[Math.floor(Math.random() * (deck.length-1 - 0 + 1))]);
dealer.addCard(deck[Math.floor(Math.random() * (deck.length-1 - 0 + 1))]);