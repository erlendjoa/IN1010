var Card = /** @class */ (function () {
    function Card(image, value) {
        this.image = image;
        this.value = value;
    }
    return Card;
}());
var Player = /** @class */ (function () {
    function Player(ids, scoreId) {
        this.ids = ids;
        this.scoreId = scoreId;
        this.hand = [];
        this.score = 0;
    }
    Player.prototype.addCard = function (newCard) {
        this.hand.push(newCard);
        this.updateCards();
    };
    Player.prototype.revealCard = function (i) {
        var _this = this;
        // Set index id image to be hand image; Add to this.score;
        setTimeout(function () {
            _this.ids[i].src = _this.hand[i].image;
            _this.scoreId.textContent = (_this.score + _this.hand[i].value).toString();
            _this.scoreId.style.visibility = "visible";
        }, 1000);
    };
    Player.prototype.updateCards = function () {
        var tempScore = 0;
        var tempHand = [];
        for (var i = 0; i < this.hand.length; i++) {
            console.log(this.ids[i]);
            var currentId = this.ids[i];
            var currentCard = this.hand[i];
            currentId.src = currentCard.image; // Set current id to be the card id
            if (currentId.style.display = "hidden") { // IF display == hidden:   WORKING??????
                currentId.style.border = "3px soild black"; // Set black border
                currentId.style.display = "block"; // Set visible;
            }
            tempHand.push(currentCard);
            tempScore += currentCard.value;
        }
        this.hand = tempHand;
        this.score = tempScore;
        this.scoreId.textContent = this.score.toString();
    };
    return Player;
}());
var Game = /** @class */ (function () {
    function Game() {
        // Assing user and dealer ids;
        var userIds = [];
        var dealerIds = [];
        for (var i = 0; i < 8; i++) {
            userIds.push(document.getElementById("ciu" + i.toString()));
            dealerIds.push(document.getElementById("cid" + i.toString()));
        }
        // Create and fill deck;
        this.deck = [];
        var typeArr = ["club", "heart", "spade", "diamond"];
        var valueArr = [11, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 10];
        for (var i = 0; i < 4; i++) {
            for (var j = 1; j < 14; j++) {
                this.deck.push(new Card("Assets/" + typeArr[i] + j.toString() + ".jpg", valueArr[j - 1]));
            }
        }
        // Create players and assign cards;
        this.user = new Player(userIds, document.getElementById("playerScore"));
        this.dealer = new Player(userIds, document.getElementById("playerScore"));
        this.user.addCard(this.deck.splice(Math.floor(Math.random() * this.deck.length), 1)[0]);
        this.user.addCard(this.deck.splice(Math.floor(Math.random() * this.deck.length), 1)[0]);
        this.dealer.addCard(this.deck.splice(Math.floor(Math.random() * this.deck.length), 1)[0]);
        this.dealer.addCard(this.deck.splice(Math.floor(Math.random() * this.deck.length), 1)[0]);
        // Hide dealers card and score.
        dealerIds[0].src = "Assets/cardBack.jpg";
        dealerIds[1].src = "Assets/cardBack.jpg";
        document.getElementById("dealerScore").style.visibility = "hidden";
    }
    Game.prototype.addCardFromButton = function () {
        this.user.addCard(this.deck.splice(Math.floor(Math.random() * this.deck.length), 1)[0]);
    };
    Game.prototype.lockInn = function () {
        // Hide the lockInn and addCard buttons;
        document.getElementById("lockInn").style.visibility = "hidden";
        document.getElementById("addCardButton").style.display = "none";
        // Reveal both dealer cards;
        this.dealer.revealCard(0);
        this.dealer.revealCard(1);
        this.dealerAddRest();
    };
    Game.prototype.switchAceFromButton = function (i) {
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
    };
    Game.prototype.dealerAddRest = function () {
        if (this.user.score == 21)
            return true;
        if (this.user.score > 21)
            return false;
        if (this.dealer.hand[0].value == 11 && this.dealer.hand[1].value == 11) {
            this.switchAce(this.dealer, this.dealer.hand[0], 0);
            this.dealerAddRest();
        }
        if (this.dealer.score >= this.user.score)
            return false;
        while (this.dealer.score < 17 && this.dealer.score < this.user.score) {
            this.dealer.addCard(this.deck[Math.floor(Math.random() * (this.deck.length - 1 - 0 + 1))]);
        }
        if (this.dealer.score < this.user.score || this.dealer.score > 21) {
            for (var i = 0; i < this.dealer.hand.length; i++) {
                if (this.dealer.hand[i].value == 11) {
                    this.switchAce(this.dealer, this.dealer.hand[i], i);
                    this.dealerAddRest();
                }
            }
        }
        if (this.dealer.score >= this.user.score && this.dealer.score <= 21)
            return false;
        return true;
    };
    Game.prototype.switchAce = function (player, ace, i) {
        ace.value = 1;
        player.ids[i].style.border = "3px solid yellow";
        player.updateCards();
    };
    return Game;
}());
var game = new Game();
