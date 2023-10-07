package com.example.mymemory.models

import com.example.mymemory.utils.DEFAULT_ICONS

class MemoryGame(private val boardSize: BoardSize) {

    val cards: List<MemoryCard>
    val numPairsFound = 0
    private var indexOfSingleSelectedCard: Int? = null

    init {
        val chosenImages = DEFAULT_ICONS.shuffled().take(boardSize.getNumPairs())
        val randomizedImages = (chosenImages + chosenImages).shuffled()
        cards = randomizedImages.map { MemoryCard(it) }
    }

    fun flipCard(position: Int) {
        val card = cards[position]

        // Three cases:
        // 0 cards previously flipped over => restore cards + flip over selected card
        // 1 card  previously flipped over =>  flip over selected card + check if the images match
        // 2 cards previously flipped over => restore cards + flip over selected card
         if (indexOfSingleSelectedCard == null) {
            restoreCards()
            indexOfSingleSelectedCard = position
        }else{
            checkForMatch(indexOfSingleSelectedCard!!,position)
        }

        card.isFaceUp = !card.isFaceUp
    }

    private fun checkForMatch(indexOfSingleSelectedCard: Int, position: Int) {

    }

    private fun restoreCards() {
        for (card in cards){
            if (!card.isMatched){
            card.isFaceUp = false

            }
        }
    }
}
