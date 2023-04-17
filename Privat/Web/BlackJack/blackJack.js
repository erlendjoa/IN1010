

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
        this.updateCards();
        setTimeout(() => {}, 600);
    }
    updateCards() {
        let tempScore = 0;
        let tempHand = [];
        for (i = 0; i < this.hand.length; i++) {
            if (i < this.hand.length) {
                this.ids[i].src = this.hand[i].getImage();
                this.ids[i].style.outline = "2px solid black";
                this.ids[i].style.display = "block";
                tempHand.push(this.hand[i]);
                tempScore += this.hand[i].value;
                setTimeout(() => {}, 200); // Add delay of 200ms after displaying each card
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
valueArr = [11,2,3,4,5,6,7,8,9,10,10,10,10];
for (i = 0; i < 4; i++) {
    for (j = 1; j < 14; j++) {
        deck.push(new Card("Assets/" + typeArr[i]+j + ".jpg", valueArr[j-1]));
    }
}


user = new Player(userIds, userScoreId);
dealer = new Player(dealerIds, dealerScoreId);
user.addCard(deck[Math.floor(Math.random() * (deck.length-1 - 0 + 1))]);
user.addCard(deck[Math.floor(Math.random() * (deck.length-1 - 0 + 1))]);
dealer.addCard(deck[Math.floor(Math.random() * (deck.length-1 - 0 + 1))]);
dealer.addCard(deck[Math.floor(Math.random() * (deck.length-1 - 0 + 1))]);

// Hide dealers card.
    dealerIds[0].src = "Assets/cardBack.jpg";
    dealerIds[1].src = "Assets/cardBack.jpg";



function addCardFromButton() {
    user.addCard(deck[Math.floor(Math.random() * (deck.length-1 - 0 + 1))]);
}
function lockInn() {
    document.getElementById("lockInn").style.visibility = "hidden";
    document.getElementById("addCardButton").style.display = "none";
    
    setTimeout(function() {
        dealerIds[0].src = dealer.hand[0].getImage();
    }, 200);
    setTimeout(function() {
        dealerIds[1].src = dealer.hand[1].getImage();
    }, 400);
    setTimeout(function() {
        dealerAddRest();
    }, 600);
}

function switchAce(player, card, index) {
    card.value = 1;
    player.ids[index].style.outline = "2px red";
    console.log(player + " bytter " + player.ids[index] + " bytter .style.outline = 2px red på index: " + index );
    player.updateCards();
}

function dealerAddRest() {

    if (user.score == 21) {
        console.log("dealer wins");
        return;
    }
    if (user.score > 21) {
        console.log("dealer wins");
        return;
    }

    if (dealer.hand[0].value == 11 && dealer.hand[1].value == 11) {     // If both are ace at start.
            switchAce(dealer, dealer.hand[0], 0);
            dealerAddRest();
    }  

    if (dealer.score >= user.score) {
        console.log("dealer wins");
        return;
    }

    while (dealer.score < 17 && dealer.score < user.score) {
        dealer.addCard(deck[Math.floor(Math.random() * (deck.length-1 - 0 + 1))])
    }

    if (dealer.score < user.score || dealer.score > 21) {
        for (i = 0; i < dealer.hand.length; i++) {
            if (dealer.hand[i].value == 11) {
                switchAce(dealer, dealer.hand[i], i);
                dealerAddRest();
            }
        }   
    }
    

    if (dealer.score >= user.score && dealer.score < 22) {
        console.log("dealer wins");
        return;
    }

    console.log("user wins");
}