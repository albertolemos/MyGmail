package com.example.mygmail.model;

import java.util.Arrays;
import java.util.List;

public class Emails {

    public static List<Email> fakeEmails(){
        return Arrays.asList(

                Email.EmailBuilder.builder()
                        .setUser("Facebook")
                        .setSubject("Veja nossas três dicas principais para aumentar as suas visualizações")
                        .setPreview("Olá, Alberto! Você precisa ver esse site")
                        .setDate("21 Sep")
                        .setUnread(true)
                        .build(),

                Email.EmailBuilder.builder()
                        .setUser("Facebook")
                        .setSubject("Você foi marcado em um publicação de Elaine Rosana")
                        .setPreview("Abra o Facebook e confira tudo o que estão falando de você")
                        .setDate("21 Sep")
                        .setUnread(true)
                        .build(),

                Email.EmailBuilder.builder()
                        .setUser("YouTube")
                        .setSubject("Assista aos vídeos mais vistos da semana")
                        .setPreview("Não deixe de ver, curtir e compartilhar os vídeos que foram ...")
                        .setDate("20 Sep")
                        .setSelected(true)
                        .build(),

                Email.EmailBuilder.builder()
                        .setUser("Elaine Rosana")
                        .setSubject("Como foi boa a nossa viagem")
                        .setPreview("Olá, meu amor! Foi muito bom passar esses dias com você em Recife")
                        .setDate("19 Sep")
                        .setStared(true)
                        .build(),

                Email.EmailBuilder.builder()
                        .setUser("Pepeu")
                        .setSubject("Quantas horas ainda tenho para jogar essa semana")
                        .setPreview("Oi, Painho! Vê pra mim quantas horas ainda posso jogar essa semana, pois talvez eu guarde pra jogar depois")
                        .setDate("24 Sep")
                        .setStared(true)
                        .setSelected(true)
                        .setUnread(true)
                        .build(),

                Email.EmailBuilder.builder()
                        .setUser("Pepeu")
                        .setSubject("Prometo que vou melhorar o meu comportamento")
                        .setPreview("Olá, Painho! Estou empenhado em mudar o meu comportamento e assim não deixar você e mainha tristes")
                        .setDate("24 Sep")
                        .setStared(true)
                        .setSelected(true)
                        .setUnread(true)
                        .build(),

                Email.EmailBuilder.builder()
                        .setUser("IFPE")
                        .setSubject("Saiu o resultado do auxílio eventual")
                        .setPreview("[RESULTADO FINAL] Você foi escolhido para receber mais uma parcela do auxílio benefício eventual")
                        .setDate("25 Sep")
                        .setUnread(true)
                        .build(),

                Email.EmailBuilder.builder()
                        .setUser("IFPE")
                        .setSubject("O seu curso está chegando ao fim, porém não é o fim de tudo")
                        .setPreview("Olá, Alberto! Foi maravilhoso ter você como nosso aluno durante esse tempo")
                        .setDate("25 Sep")
                        .setUnread(true)
                        .build()
        );
    }
}
