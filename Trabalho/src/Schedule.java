public class Schedule { // Lógica do algoritmo
    private int CountCiclosAltaPrioridade = 0;
    ListaDeProcessos ListaAltaPrioridade = new ListaDeProcessos();
    ListaDeProcessos ListaMediaPrioridade = new ListaDeProcessos();
    ListaDeProcessos ListaBaixaPrioridade = new ListaDeProcessos();
    ListaDeProcessos ProcessosBloqueados = new ListaDeProcessos();

    public void executarCiclosDeCPU(){
        gerenciarProcessosBloqueados();
        if(CountCiclosAltaPrioridade >= 5){ // Prevenção de inanição 
            if(ListaMediaPrioridade.listaVazia()){ // Confere se a lista de processos de prioridade media esta vazia
                if(ListaBaixaPrioridade.listaVazia()){ // Confere se a lista de processos de prioridade baixa esta vazia
                } else { // Consequência se a lista de Processo baixa possuir ao menos um elemento
                    Processo ProcessoEmExecucao = ListaBaixaPrioridade.removerInicio(); // Remove o primeiro processo da lista de baixa prioridade e armazena na variavel "ProcessoEmExecução".
                    if (ProcessoEmExecucao.getRecurso_necessario() != null && // Verifica se esse processo precisa de um recurso externo
                    ProcessoEmExecucao.getRecurso_necessario().equals("DISCO") && 
                    !ProcessoEmExecucao.getJaRequisitou()){
                        ProcessoEmExecucao.setJaRequisitou(true); // Define como true que esse processo precisa de recurso externo
                        ProcessosBloqueados.adicionarProcesso(ProcessoEmExecucao); // Adiciona esse processo na lista de processos bloqueados
                        return;
                    } else {
                        // Imprime os dados do processo
                        System.out.println("|------------------------------------------------|");
                        System.out.println("|Nome processo executado: "+ProcessoEmExecucao.getNome());
                        System.out.println("|ID do processo executado: "+ProcessoEmExecucao.getId());
                        System.out.println("|Prioridade do processo executado: "+ProcessoEmExecucao.getPrioridade());
                        System.out.println("|Quantidade de ciclos processo executado: "+ProcessoEmExecucao.getCiclos_necessarios());
                        System.out.println("|Recurso necessário do processo executado: "+ProcessoEmExecucao.getRecurso_necessario());
                        System.out.println("|------------------------------------------------|");
                        ProcessoEmExecucao.setCiclos_necessarios(ProcessoEmExecucao.getCiclos_necessarios()-1); // Diminui 1 da quantidade de ciclos desse processo 
                        if(ProcessoEmExecucao.getCiclos_necessarios() > 0){ // Verifica se precisa adicionar ele denovo na lista
                            ListaBaixaPrioridade.adicionarProcesso(ProcessoEmExecucao); // Adicionar esse processo no final da lista
                        } else {
                            System.out.println("Processo: "+ProcessoEmExecucao.getNome()+" Finalizado"); // Imprime que o processo foi finalizado
                        }
                        CountCiclosAltaPrioridade = 0; // Coloca o contador de ciclos de alta prioridade como 0 
                        return; 
                    }
                }
            } else { // Consequência se a lista de Processo Media possuir ao menos um elemento
                Processo ProcessoEmExecucao = ListaMediaPrioridade.removerInicio(); // Remove o primeiro processo da lista de baixa prioridade e armazena na variavel "ProcessoEmExecução"
                if(ProcessoEmExecucao.getRecurso_necessario() != null && // Verifica se esse processo precisa de um recurso externo
                ProcessoEmExecucao.getRecurso_necessario().equals("DISCO") && 
                !ProcessoEmExecucao.getJaRequisitou()){
                    ProcessoEmExecucao.setJaRequisitou(true); // Define como true que esse processo precisa de recurso externo
                    ProcessosBloqueados.adicionarProcesso(ProcessoEmExecucao); // Adicionar esse processo no final da lista
                    return;
                } else {
                    // Imprime os dados do processo
                    System.out.println("|------------------------------------------------|");
                    System.out.println("|Nome processo executado: "+ProcessoEmExecucao.getNome());
                    System.out.println("|ID do processo executado: "+ProcessoEmExecucao.getId());
                    System.out.println("|Prioridade do processo executado: "+ProcessoEmExecucao.getPrioridade());
                    System.out.println("|Quantidade de ciclos processo executado: "+ProcessoEmExecucao.getCiclos_necessarios());
                    System.out.println("|Recurso necessário do processo executado: "+ProcessoEmExecucao.getRecurso_necessario());
                    System.out.println("|------------------------------------------------|");
                    ProcessoEmExecucao.setCiclos_necessarios(ProcessoEmExecucao.getCiclos_necessarios()-1); // Diminui 1 da quantidade de ciclos desse processo 
                    if(ProcessoEmExecucao.getCiclos_necessarios() > 0){ // Verifica se precisa adicionar ele denovo na lista
                        ListaMediaPrioridade.adicionarProcesso(ProcessoEmExecucao); // Adicionar esse processo no final da lista
                    } else {
                        System.out.println("Processo: "+ProcessoEmExecucao.getNome()+" Finalizado"); // Imprime que o processo foi finalizado
                    }
                    CountCiclosAltaPrioridade = 0; // Coloca o contador de ciclos de alta prioridade como 0
                    return;
                }
            }
        } else { // Caso nao tenha processos nas listas de media ou baixa prioridade vai para a lista de alta prioridade
            if(ListaAltaPrioridade.listaVazia()){ // Confere se a lista de alta prioridade esta vazia 
                if(ListaMediaPrioridade.listaVazia()){ // Confere se a lista de media prioridade esta vazia 
                    if(ListaBaixaPrioridade.listaVazia()){ // Confere se a lista de baixa prioridade esta vazia
                        System.out.println("Não a mais processo!"); // Imprime que não tem mais processos
                    } else { // Consguencia da lista de baixa prioridade ter ao menos um processo
                        Processo ProcessoEmExecucao = ListaBaixaPrioridade.removerInicio(); // Remove o primeiro processo da lista de baixa prioridade e armazena na variavel "ProcessoEmExecução"
                        if(ProcessoEmExecucao.getRecurso_necessario() != null && // Verifica se esse processo precisa de um recurso externo
                        ProcessoEmExecucao.getRecurso_necessario().equals("DISCO") && 
                        !ProcessoEmExecucao.getJaRequisitou()){
                            ProcessoEmExecucao.setJaRequisitou(true); // Define como true que esse processo precisa de recurso externo
                            ProcessosBloqueados.adicionarProcesso(ProcessoEmExecucao); // Adicionar esse processo no final da lista
                            return;
                        } else {
                            // Imprime os dados do processo
                            System.out.println("|------------------------------------------------|");
                            System.out.println("|Nome processo executado: "+ProcessoEmExecucao.getNome());
                            System.out.println("|ID do processo executado: "+ProcessoEmExecucao.getId());
                            System.out.println("|Prioridade do processo executado: "+ProcessoEmExecucao.getPrioridade());
                            System.out.println("|Quantidade de ciclos processo executado: "+ProcessoEmExecucao.getCiclos_necessarios());
                            System.out.println("|Recurso necessário do processo executado: "+ProcessoEmExecucao.getRecurso_necessario());
                            System.out.println("|------------------------------------------------|");
                            ProcessoEmExecucao.setCiclos_necessarios(ProcessoEmExecucao.getCiclos_necessarios()-1); // Diminui 1 da quantidade de ciclos desse processo
                            if(ProcessoEmExecucao.getCiclos_necessarios() > 0){ // Verifica se precisa adicionar ele denovo na lista
                                ListaBaixaPrioridade.adicionarProcesso(ProcessoEmExecucao); // Adicionar esse processo no final da lista
                            } else {
                                System.out.println("Processo: "+ProcessoEmExecucao.getNome()+" Finalizado"); // Imprime que o processo foi finalizado
                            }
                            return;
                        } 
                    }
                } else { // Conseguencia da lista de media prioridade ter ao menos um processo
                    Processo ProcessoEmExecucao = ListaMediaPrioridade.removerInicio(); // Remove o primeiro processo da lista de baixa prioridade e armazena na variavel "ProcessoEmExecução"
                    if(ProcessoEmExecucao.getRecurso_necessario() != null && // Verifica se esse processo precisa de um recurso externo
                    ProcessoEmExecucao.getRecurso_necessario().equals("DISCO") && 
                    !ProcessoEmExecucao.getJaRequisitou()){
                        ProcessoEmExecucao.setJaRequisitou(true);  // Define como true que esse processo precisa de recurso externo
                        ProcessosBloqueados.adicionarProcesso(ProcessoEmExecucao); // Adicionar esse processo no final da lista
                        return;
                    } else {
                        // Imprime os dados do processo
                        System.out.println("|------------------------------------------------|");
                        System.out.println("|Nome processo executado: "+ProcessoEmExecucao.getNome());
                        System.out.println("|ID do processo executado: "+ProcessoEmExecucao.getId());
                        System.out.println("|Prioridade do processo executado: "+ProcessoEmExecucao.getPrioridade());
                        System.out.println("|Quantidade de ciclos processo executado: "+ProcessoEmExecucao.getCiclos_necessarios());
                        System.out.println("|Recurso necessário do processo executado: "+ProcessoEmExecucao.getRecurso_necessario());
                        System.out.println("|------------------------------------------------|");
                        ProcessoEmExecucao.setCiclos_necessarios(ProcessoEmExecucao.getCiclos_necessarios()-1); // Diminui 1 da quantidade de ciclos desse processo
                        if(ProcessoEmExecucao.getCiclos_necessarios() > 0){ // Verifica se precisa adicionar ele denovo na lista
                            ListaMediaPrioridade.adicionarProcesso(ProcessoEmExecucao); // Adicionar esse processo no final da lista
                        } else {
                            System.out.println("Processo: "+ProcessoEmExecucao.getNome()+" Finalizado"); // Imprime que o processo foi finalizado
                        }
                        return;
                    } 
                }
            } else { // Conseguencia da lista de alta prioridade ter ao menos um processo
                Processo ProcessoEmExecucao = ListaAltaPrioridade.removerInicio(); // Remove o primeiro processo da lista de baixa prioridade e armazena na variavel "ProcessoEmExecução"
                if(ProcessoEmExecucao.getRecurso_necessario() != null && // Verifica se esse processo precisa de um recurso externo
                ProcessoEmExecucao.getRecurso_necessario().equals("DISCO") && 
                !ProcessoEmExecucao.getJaRequisitou()){
                    ProcessoEmExecucao.setJaRequisitou(true); // Define como true que esse processo precisa de recurso externo
                    ProcessosBloqueados.adicionarProcesso(ProcessoEmExecucao); // Adicionar esse processo no final da lista
                    return;
                } else { 
                    CountCiclosAltaPrioridade++; // Adiciona 1 na quantidade de ciclos de alta prioridade que foram executados
                    // Impreime os dados do processso
                    System.out.println("|------------------------------------------------|");
                    System.out.println("|Nome processo executado: "+ProcessoEmExecucao.getNome());
                    System.out.println("|ID do processo executado: "+ProcessoEmExecucao.getId());
                    System.out.println("|Prioridade do processo executado: "+ProcessoEmExecucao.getPrioridade());
                    System.out.println("|Quantidade de ciclos processo executado: "+ProcessoEmExecucao.getCiclos_necessarios());
                    System.out.println("|Recurso necessário do processo executado: "+ProcessoEmExecucao.getRecurso_necessario());
                    System.out.println("|------------------------------------------------|"); 
                    ProcessoEmExecucao.setCiclos_necessarios(ProcessoEmExecucao.getCiclos_necessarios()-1); // Diminui 1 da quantidade de ciclos desse processo
                    if(ProcessoEmExecucao.getCiclos_necessarios() > 0){ // Verifica se precisa adicionar ele denovo na lista
                        ListaAltaPrioridade.adicionarProcesso(ProcessoEmExecucao); // Adicionar esse processo no final da lista
                    } else {
                        System.out.println("Processo: "+ProcessoEmExecucao.getNome()+" Finalizado"); // Imprime que o processo foi finalizado
                    }
                    return;
                }
            }
        }
    }
    public void gerenciarProcessosBloqueados(){ // Metodo que vai pegar o primeiro processo que foi adicionado a lista de bloqueados e colocar ele na lista com sua devida prioridade
        if (ProcessosBloqueados.getSize() > 0){ // Verifica se tem ao menos 1 processo na lista
            Processo ProcessoDesbloqueado = ProcessosBloqueados.removerInicio(); // Remove o primeiro dos processos e armazena na variável
            if(ProcessoDesbloqueado.getPrioridade() == 1){ // Verifica a prioridade dele como 1 e o coloca na lista de alta prioridade
                ListaAltaPrioridade.adicionarProcesso(ProcessoDesbloqueado);
            } 
            else if (ProcessoDesbloqueado.getPrioridade() == 2){ // Verifica a prioridade dele como 2 e o coloca na lista de media prioridade
                ListaMediaPrioridade.adicionarProcesso(ProcessoDesbloqueado);
            } 
            else if (ProcessoDesbloqueado.getPrioridade() == 3){ // Verifica a prioridade dele como 3 coloca na lista de baixa prioridade
                ListaBaixaPrioridade.adicionarProcesso(ProcessoDesbloqueado);
            } else {
                System.out.println("Essa prioridade não existe"); // não adiciona o processo na lista pois ele nao tem nenhuma prioridade existente
            }
        }
    }
    public void AdicionarFilas(Processo processo){ // Metodo que adicionar o processo em sua devida lista de prioridade.
        if (processo.getPrioridade() == 1){ // Recebe a prioridade do processo e caso seja 1 adiciona ele na lista de alta prioridade.
            ListaAltaPrioridade.adicionarProcesso(processo);
        }
        else if(processo.getPrioridade() == 2){ // Recebe a prioridade do processo e caso seja 1 adiciona ele na lista de media prioridade.
            ListaMediaPrioridade.adicionarProcesso(processo);
        }
        else if(processo.getPrioridade() == 3){ // Recebe a prioridade do processo e caso seja 1 adiciona ele na lista de baixa prioridade.
            ListaBaixaPrioridade.adicionarProcesso(processo);
        } else {
            System.out.println("Prioridade não existente"); // Não adicionar esse processo pois sua prioridade não existe.
        }
    }
}
