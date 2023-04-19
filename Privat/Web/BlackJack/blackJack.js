

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
    }
    updateCards() {
        let tempScore = 0;
        let tempHand = [];
        for (let i = 0; i < this.hand.length; i++) {
                this.ids[i].src = this.hand[i].image;
                this.ids[i].style.border = "3px solid black";
                this.ids[i].style.display = "block";
                tempHand.push(this.hand[i]);
                tempScore += this.hand[i].value;
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
let dealerScoreId = document.getElementById("dealerScore");
let userScoreId = document.getElementById("playerScore");
let dealerIds = [];
let userIds = [];
for (let i = 0; i < 8; i++) {
    dealerIds.push(document.getElementById("cid" + i));
    userIds.push(document.getElementById("ciu" + i));
}

// Create and push new Cards to deck[].
let deck = [];  
let typeArr = ["club", "heart", "spade", "diamond"];
let valueArr = [11,2,3,4,5,6,7,8,9,10,10,10,10];
for (let i = 0; i < 4; i++) {
    for (let j = 1; j < 14; j++) {
        deck.push(new Card("Assets/" + typeArr[i]+j + ".jpg", valueArr[j-1]));
    }
}

let user = new Player(userIds, userScoreId);
let dealer = new Player(dealerIds, dealerScoreId);

user.addCard(deck.splice(Math.floor(Math.random() * deck.length), 1)[0]);
user.addCard(deck.splice(Math.floor(Math.random() * deck.length), 1)[0]);
dealer.addCard(deck.splice(Math.floor(Math.random() * deck.length), 1)[0]);
dealer.addCard(deck.splice(Math.floor(Math.random() * deck.length), 1)[0]);

// Hide dealers card and score.
dealerIds[0].src = "Assets/cardBack.jpg";
dealerIds[1].src = "Assets/cardBack.jpg";
document.getElementById("dealerScore").style.visibility = "hidden";


function addCardFromButton() {
    user.addCard(deck.splice(Math.floor(Math.random() * deck.length), 1)[0]);
}
function lockInn() {
    document.getElementById("lockInn").style.visibility = "hidden";
    document.getElementById("addCardButton").style.display = "none";
    
    setTimeout(function() {
        dealerIds[0].src = dealer.hand[0].getImage();
        document.getElementById("dealerScore").textContent = dealer.hand[0].value
        document.getElementById("dealerScore").style.visibility = "visible";
    }, 200);
    setTimeout(function() {
        dealerIds[1].src = dealer.hand[1].getImage();
        document.getElementById("dealerScore").textContent = dealer.hand[0].value + dealer.hand[1].value
    }, 600);
    setTimeout(function() {
        dealerAddRest();
    }, 1000);
}

function switchAce(player, card, index) {
    card.value = 1;
    player.updateCards();
    player.ids[index].style.border = "3px solid rgb(170, 176, 63)";
}

function switchAceFromButton(index) {
    if (user.hand[index].value == 11) {
        user.hand[index].value = 1;
        user.updateCards();
        user.ids[index].style.border = "3px solid rgb(170, 176, 63)";
        return;
    } 
    if (user.hand[index].value == 1) {
        user.hand[index].value = 11;
        user.updateCards();
        user.ids[index].style.border = "3px solid black";
        return;
    }
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
        for (let i = 0; i < dealer.hand.length; i++) {
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

