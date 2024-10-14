

# 🃏 Blackjack 21 - Command Line Edition

Welcome to **Blackjack 21** – a no-frills, command-line version of the classic card game, written entirely in Java. With simulated betting, you'll start with **$1000** and try to make your way to riches (or go broke trying)

> **Note:** The game is in **Portuguese** – so if you're not familiar, now might be a good time to pick up a new language

![Java](https://img.shields.io/badge/Java-17%2B-blue) ![Blackjack](https://img.shields.io/badge/Blackjack-21-critical) ![Promptline](https://img.shields.io/badge/UI-Command--line-lightgrey)

## 🎮 Gameplay Features

- Play a game of **Blackjack 21** right from your command line
- Simulated **betting** system with starting balance of **$1000**
- Interface in **Portuguese**, but Blackjack's rules are universal, ofc

## 🚀 Getting Started

1. Clone or download the repository
   ```bash
   git clone https://github.com/arminosz/blackjack21.git
   ```
2. Make sure you have **Java 17+ (or JDK17)** installed and downloaded both java and manifest files
3. Compile the game with:
   ```bash
   javac BlackjackGame.java
   ```
4. Compile the game to jar with:
   ```bash
   jar cfm BlackjackGame.jar manifest.txt BlackjackGame.class
   ```
5. Run the game with:
   ```bash
   java -jar BlackjackGame.jar
   ```
   <sub>(If you downloaded the jar from releases, start from step 5)</sub>

## 💵 Betting System

- You start with **$1000**
- Place your bet before the round starts
- If you win, you double your bet. If you lose, well, you lose

## 🛠️ Requirements

- **Java 17** or higher
- A terminal or command-line interface (obviously)

## 🇧🇷 Tutorial Rápido (em português)

Se você é brasileiro, ou entende português, aqui um tutorial rápido para jogar:

1. **Jogar**: Quando o jogo começar, você será pedido para fazer uma **aposta**. Digite o valor e pressione **Enter**
2. **Ações**: Durante o jogo, você pode:
   - **Pedir** (Hit): Receber outra carta para tentar chegar mais perto de 21
   - **Parar** (Stand): Manter suas cartas e passar a vez para o dealer
3. **Objetivo**: Chegar o mais perto de 21 sem estourar. Se o dealer passar de 21, você ganha. Se suas cartas forem maiores que as do dealer sem estourar, você também ganha!

Lembre-se, o saldo inicial é de **$1000** e a cada vitória, você **duplica sua aposta**

---
**Disclaimer:** This game is purely for fun, and no real money is involved (unfortunately)
