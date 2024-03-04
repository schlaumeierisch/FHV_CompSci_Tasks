NimGame
	Integer row1 = 1
	Integer row2 = 2
	Integer row3 = 3
	Integer selectedRow = 0
	
	Integer row1Coins = 5
	Integer row2Coins = 4
	Integer row3Coins = 3
	
	Integer totalCoins := row1Coins + row2Coins + row3Coins
	Integer selectedCoins = 0
	
	Integer Player1 = 1
	Integer Player2 = 2
	Integer currentPlayer = 1
	
	Player1CoinSelection										// Spieler 1 wählt Anzahl der Münzen aus
	Player1RowSelection											// Spieler 1 wählt Reihe aus

	Player2CoinSelection										// Spieler 2 wählt Anzahl der Münzen aus
	Player2RowSelection											// Spieler 2 wählt Reihe aus
	
	while (allCoins > 0) do
		if (currentPlayer == 1) then
			Player1CoinSelection
			Player1RowSelection
			
			while ((selectedRow > 3) and (selectedRow < 0) do
				Player1RowSelection
			end while
			// sicherstellen, dass eine der 3 verfügbaren Reihen gewählt wurde
			
			if (selectedRow == row1) then
				while ((selectedCoins > row1Coins) and (selectedCoins < 0)) do
					Player1CoinSelection
				end while
				// sicherstellen, dass die gewählte Anzahl der Münzen nicht höher ist, als in Reihe 1 verfügbar
				
				row1Coins := row1Coins - selectedCoins
			end if
			
			if (selectedRow == row2) then
				while ((selectedCoins > row2Coins) and (selectedCoins < 0)) do
					Player1CoinSelection
				end while
				// sicherstellen, dass die gewählte Anzahl der Münzen nicht höher ist, als in Reihe 2 verfügbar
				
				row2Coins := row2Coins - selectedCoins
			end if
			
			if (selectedRow == row3) then
				while ((selectedCoins > row3Coins) and (selectedCoins < 0)) do
					Player1CoinSelection
				end while
				// sicherstellen, dass die gewählte Anzahl der Münzen nicht höher ist, als in Reihe 3 verfügbar
				
				row3Coins := row3Coins - selectedCoins
			end if
			
			currentPlayer := currentPlayer + 1
		else
			Player2CoinSelection
			Player2RowSelection
			
			while ((selectedRow > 3) and (selectedRow < 0) do
				Player2RowSelection
			end while
			// sicherstellen, dass eine der 3 verfügbaren Reihen gewählt wurde
			
			if (selectedRow == row1) then
				while ((selectedCoins > row1Coins) and (selectedCoins < 0)) do
					Player2CoinSelection
				end while
				// sicherstellen, dass die gewählte Anzahl der Münzen nicht höher ist, als in Reihe 1 verfügbar
				
				row1Coins := row1Coins - selectedCoins
			end if
			
			if (selectedRow == row2) then
				while ((selectedCoins > row2Coins) and (selectedCoins < 0)) do
					Player2CoinSelection
				end while
				// sicherstellen, dass die gewählte Anzahl der Münzen nicht höher ist, als in Reihe 2 verfügbar
				
				row2Coins := row2Coins - selectedCoins
			end if
			
			if (selectedRow == row3) then
				while ((selectedCoins > row3Coins) and (selectedCoins < 0)) do
					Player2CoinSelection
				end while
				// sicherstellen, dass die gewählte Anzahl der Münzen nicht höher ist, als in Reihe 3 verfügbar
				
				row3Coins := row3Coins - selectedCoins
			end if

			currentPlayer := currentPlayer -1
		end if
		
		totalCoins := totalCoins - selectedCoins
	end while
end NimGame