package com.example.nivelamento

class ServicePessoa {

    private val pessoas = mutableListOf<Pessoa>();

    fun cadastrar(nome: String): Unit {
        validaoNome(nome);
        pessoas.add(Pessoa(nome));
        println("$nome cadastrado com sucesso!");
    }

    fun listar(): Unit {
        println(pessoas.forEach { println(it.nome) });
    }

    fun pesquisar(nome: String): Pessoa? {
        return pessoas.find { it.nome.equals(nome, ignoreCase = true) }
    }

    fun remover(nome: String): Unit {
        validaoNome(nome);
        val pessoa = pesquisar(nome);

        pessoas.removeIf { it.nome.equals(nome, ignoreCase = true) }
        println("pessoa removida: ${nome}");
    }

    fun alterar(nomeAntigo: String, nomeNovo: String) {
        validaoNome(nomeAntigo);
        validaoNome(nomeNovo);
        val index = pesquisar(nomeAntigo)?.let { pessoas.indexOf(it) } ?: -1;

        if (index != -1) {
            pessoas[index] = Pessoa(nomeNovo);
            println("Sucesso: '$nomeAntigo' alterado para '$nomeNovo'.");
        } else {
            println("Erro: Pessoa '$nomeAntigo' não encontrada na lista.");
        }
    }

    private fun validaoNome(nome: String) {
        nome.trim().let {
            if (it.isBlank()) {
                println("Nome não pode ser vazio.");
                return;
            }
        }
    }
}