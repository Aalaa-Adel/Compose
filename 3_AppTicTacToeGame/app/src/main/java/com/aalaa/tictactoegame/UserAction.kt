package com.aalaa.tictactoegame

sealed class UserAction {
    data object PlayAgainButtonClicked: UserAction()
    data class BoardTapped(val cellNo: Int): UserAction()
}