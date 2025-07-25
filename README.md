# Sudoku - Java

Projeto em Java para **jogar Sudoku via terminal**, com suporte a inserção manual de valores e uma funcionalidade extra de resolução automática como sugestão ou auxílio.

## 📦 Estrutura do Projeto


## 🧩 Funcionalidades

- Interface de texto interativa para jogar Sudoku
- Inserção manual de valores no tabuleiro
- Validação automática de jogadas
- Visualização do progresso
- Resolução automática como recurso extra (`Solver`)

## 🧠 Classes Principais

- **`Main`**: Inicia o menu interativo no terminal
- **`Board`**: Representa o tabuleiro 9x9 e regras do Sudoku
- **`Cell`**: Estrutura básica de célula (linha, coluna, valor)
- **`Mapper`**: Utilitário para entrada de dados e argumentos
- **`Solver`**: Algoritmo automático de tentativa e erro (opcional)

## ▶️ Como Executar

### 1. Compilar:

```bash
javac -d out src/com/jonas/study/*.java

## 🧪 Rodar com jogo pré-carregado

```bash
java -cp out com.jonas.study.Main \
"2,0;9,true" "4,0;8,true" "5,0;6,true" "6,0;2,true" \
"1,1;3,true" "4,1;7,true" "7,1;9,true" "8,1;6,true" \
"1,2;6,true" "4,2;1,true" "8,2;5,true" \
"0,3;5,true" "2,3;3,true" "7,3;8,true" \
"1,4;9,true" "3,4;1,true" "4,4;2,true" "5,4;5,true" "7,4;6,true" \
"1,5;4,true" "6,5;1,true" "8,5;7,true" \
"0,6;7,true" "4,6;3,true" "7,6;1,true" \
"0,7;9,true" "1,7;8,true" "4,7;4,true" "7,7;2,true" \
"2,8;6,true" "3,8;8,true" "4,8;5,true" "6,8;4,true"


