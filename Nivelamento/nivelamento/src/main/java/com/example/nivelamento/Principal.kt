package com.example.nivelamento

import java.util.InputMismatchException
import java.util.Scanner

fun main() {
    val servicePessoa = ServicePessoa();
    val scanner = Scanner(System.`in`)
    var opcao: Int = 0

    while (opcao != 6) {
        try {
            println("1 - Cadastrar / 2 - Listar / 3 - Pesquisar / 4 - Alterar / 5 - Remover / 6 - Finalizar")
            print("Informe o número da lista: ")
            opcao = scanner.nextInt()

            when (opcao) {
                1 -> {
                    println("Nome: ")
                    servicePessoa.cadastrar(scanner.next())
                }

                2 -> servicePessoa.obterListaPessoas()
                3 -> {
                    println("Nome: ")
                    val nomePessoa = servicePessoa.pesquisar(scanner.next());
                    println(nomePessoa ?: "Não encontrado.")
                }

                4 -> {
                    print("Nome atual: ")
                    val nomeAntigo = scanner.next()

                    print("Novo nome: ")
                    val nomeNovo = scanner.next()

                    servicePessoa.alterar(nomeAntigo, nomeNovo)
                }

                5 -> {
                    println("Nome: ")
                    servicePessoa.remover(scanner.next())
                }

                6 -> println("Finalizando o programa")
                else -> println("Opção inválida, tente novamente.")
            }

        } catch (e: InputMismatchException) {
            println("Incompatibilidade na entrada " + e)
            scanner.nextLine()
            opcao = 0

        } catch (ex: Exception) {
            println("Erro no processamento " + ex)
            scanner.nextLine()
            opcao = 0
        }
    }
}




