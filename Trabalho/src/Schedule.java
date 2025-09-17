public class Schedule {
    private int CountCiclosAltaPrioridade = 0;
    ListaDeProcessos ListaAltaPrioridade = new ListaDeProcessos();
    ListaDeProcessos ListaMediaPrioridade = new ListaDeProcessos();
    ListaDeProcessos ListaBaixaPrioridade = new ListaDeProcessos();
    ListaDeProcessos ProcessosBloqueados = new ListaDeProcessos();

    public void executarCiclosDeCPU(){
        gerenciarProcessosBloqueados();
        if(CountCiclosAltaPrioridade >= 5){
            if(ListaMediaPrioridade.listaVazia()){
                if(ListaBaixaPrioridade.listaVazia()){
                } else {
                    Processo ProcessoEmExecucao = ListaBaixaPrioridade.removerInicio();
                    if (ProcessoEmExecucao.getRecurso_necessario() != null && 
                    ProcessoEmExecucao.getRecurso_necessario().equals("DISCO") && 
                    !ProcessoEmExecucao.getJaRequisitou()){
                        ProcessoEmExecucao.setJaRequisitou(true);
                        ProcessosBloqueados.adicionarProcesso(ProcessoEmExecucao);
                        return;
                    } else {
                        System.out.println("|------------------------------------------------|");
                        System.out.println("|Nome processo executado: "+ProcessoEmExecucao.getNome());
                        System.out.println("|ID do processo executado: "+ProcessoEmExecucao.getId());
                        System.out.println("|Prioridade do processo executado: "+ProcessoEmExecucao.getPrioridade());
                        System.out.println("|Quantidade de ciclos processo executado: "+ProcessoEmExecucao.getCiclos_necessarios());
                        System.out.println("|Recurso necessário do processo executado: "+ProcessoEmExecucao.getRecurso_necessario());
                        System.out.println("|------------------------------------------------|");
                        ProcessoEmExecucao.setCiclos_necessarios(ProcessoEmExecucao.getCiclos_necessarios()-1);
                        if(ProcessoEmExecucao.getCiclos_necessarios() > 0){
                            ListaBaixaPrioridade.adicionarProcesso(ProcessoEmExecucao);
                        } else {
                            System.out.println("Processo: "+ProcessoEmExecucao.getNome()+" Finalizado");
                        }
                        CountCiclosAltaPrioridade = 0;
                        return;
                    }
                }
            } else {
                Processo ProcessoEmExecucao = ListaMediaPrioridade.removerInicio();
                if(ProcessoEmExecucao.getRecurso_necessario() != null &&
                ProcessoEmExecucao.getRecurso_necessario().equals("DISCO") && 
                !ProcessoEmExecucao.getJaRequisitou()){
                    ProcessoEmExecucao.setJaRequisitou(true);
                    ProcessosBloqueados.adicionarProcesso(ProcessoEmExecucao);
                    return;
                } else {
                    System.out.println("|------------------------------------------------|");
                    System.out.println("|Nome processo executado: "+ProcessoEmExecucao.getNome());
                    System.out.println("|ID do processo executado: "+ProcessoEmExecucao.getId());
                    System.out.println("|Prioridade do processo executado: "+ProcessoEmExecucao.getPrioridade());
                    System.out.println("|Quantidade de ciclos processo executado: "+ProcessoEmExecucao.getCiclos_necessarios());
                    System.out.println("|Recurso necessário do processo executado: "+ProcessoEmExecucao.getRecurso_necessario());
                    System.out.println("|------------------------------------------------|");
                    ProcessoEmExecucao.setCiclos_necessarios(ProcessoEmExecucao.getCiclos_necessarios()-1);
                    if(ProcessoEmExecucao.getCiclos_necessarios() > 0){
                        ListaMediaPrioridade.adicionarProcesso(ProcessoEmExecucao);
                    } else {
                        System.out.println("Processo: "+ProcessoEmExecucao.getNome()+" Finalizado");
                    }
                    CountCiclosAltaPrioridade = 0;
                    return;
                }
            }
        } else {
            if(ListaAltaPrioridade.listaVazia()){
                if(ListaMediaPrioridade.listaVazia()){
                    if(ListaBaixaPrioridade.listaVazia()){
                        System.out.println("Não a mais processo!");
                    } else {
                        Processo ProcessoEmExecucao = ListaBaixaPrioridade.removerInicio();
                        if(ProcessoEmExecucao.getRecurso_necessario() != null &&
                        ProcessoEmExecucao.getRecurso_necessario().equals("DISCO") &&
                        !ProcessoEmExecucao.getJaRequisitou()){
                            ProcessoEmExecucao.setJaRequisitou(true);
                            ProcessosBloqueados.adicionarProcesso(ProcessoEmExecucao);
                            return;
                        } else {
                            System.out.println("|------------------------------------------------|");
                            System.out.println("|Nome processo executado: "+ProcessoEmExecucao.getNome());
                            System.out.println("|ID do processo executado: "+ProcessoEmExecucao.getId());
                            System.out.println("|Prioridade do processo executado: "+ProcessoEmExecucao.getPrioridade());
                            System.out.println("|Quantidade de ciclos processo executado: "+ProcessoEmExecucao.getCiclos_necessarios());
                            System.out.println("|Recurso necessário do processo executado: "+ProcessoEmExecucao.getRecurso_necessario());
                            System.out.println("|------------------------------------------------|");
                            ProcessoEmExecucao.setCiclos_necessarios(ProcessoEmExecucao.getCiclos_necessarios()-1);
                            if(ProcessoEmExecucao.getCiclos_necessarios() > 0){
                                ListaBaixaPrioridade.adicionarProcesso(ProcessoEmExecucao);
                            } else {
                                System.out.println("Processo: "+ProcessoEmExecucao.getNome()+" Finalizado");
                            }
                            return;
                        } 
                    }
                } else {
                    Processo ProcessoEmExecucao = ListaMediaPrioridade.removerInicio();
                    if(ProcessoEmExecucao.getRecurso_necessario() != null && 
                    ProcessoEmExecucao.getRecurso_necessario().equals("DISCO") && 
                    !ProcessoEmExecucao.getJaRequisitou()){
                        ProcessoEmExecucao.setJaRequisitou(true);
                        ProcessosBloqueados.adicionarProcesso(ProcessoEmExecucao);
                        return;
                    } else {
                        System.out.println("|------------------------------------------------|");
                        System.out.println("|Nome processo executado: "+ProcessoEmExecucao.getNome());
                        System.out.println("|ID do processo executado: "+ProcessoEmExecucao.getId());
                        System.out.println("|Prioridade do processo executado: "+ProcessoEmExecucao.getPrioridade());
                        System.out.println("|Quantidade de ciclos processo executado: "+ProcessoEmExecucao.getCiclos_necessarios());
                        System.out.println("|Recurso necessário do processo executado: "+ProcessoEmExecucao.getRecurso_necessario());
                        System.out.println("|------------------------------------------------|");
                        ProcessoEmExecucao.setCiclos_necessarios(ProcessoEmExecucao.getCiclos_necessarios()-1);
                        if(ProcessoEmExecucao.getCiclos_necessarios() > 0){
                            ListaMediaPrioridade.adicionarProcesso(ProcessoEmExecucao);
                        } else {
                            System.out.println("Processo: "+ProcessoEmExecucao.getNome()+" Finalizado");
                        }
                        return;
                    } 
                }
            } else {
                Processo ProcessoEmExecucao = ListaAltaPrioridade.removerInicio();
                if(ProcessoEmExecucao.getRecurso_necessario() != null && 
                ProcessoEmExecucao.getRecurso_necessario().equals("DISCO") && 
                !ProcessoEmExecucao.getJaRequisitou()){
                    ProcessoEmExecucao.setJaRequisitou(true);
                    ProcessosBloqueados.adicionarProcesso(ProcessoEmExecucao);
                    return;
                } else { 
                    CountCiclosAltaPrioridade++;
                    System.out.println("|------------------------------------------------|");
                    System.out.println("|Nome processo executado: "+ProcessoEmExecucao.getNome());
                    System.out.println("|ID do processo executado: "+ProcessoEmExecucao.getId());
                    System.out.println("|Prioridade do processo executado: "+ProcessoEmExecucao.getPrioridade());
                    System.out.println("|Quantidade de ciclos processo executado: "+ProcessoEmExecucao.getCiclos_necessarios());
                    System.out.println("|Recurso necessário do processo executado: "+ProcessoEmExecucao.getRecurso_necessario());
                    System.out.println("|------------------------------------------------|"); 
                    ProcessoEmExecucao.setCiclos_necessarios(ProcessoEmExecucao.getCiclos_necessarios()-1);
                    if(ProcessoEmExecucao.getCiclos_necessarios() > 0){
                        ListaAltaPrioridade.adicionarProcesso(ProcessoEmExecucao);
                    } else {
                        System.out.println("Processo: "+ProcessoEmExecucao.getNome()+" Finalizado");
                    }
                    return;
                }
            }
        }
    }
    public void gerenciarProcessosBloqueados(){
        if (ProcessosBloqueados.getSize() > 0){
            Processo ProcessoDesbloqueado = ProcessosBloqueados.removerInicio();
            if(ProcessoDesbloqueado.getPrioridade() == 1){
                ListaAltaPrioridade.adicionarProcesso(ProcessoDesbloqueado);
            } 
            else if (ProcessoDesbloqueado.getPrioridade() == 2){
                ListaMediaPrioridade.adicionarProcesso(ProcessoDesbloqueado);
            } 
            else if (ProcessoDesbloqueado.getPrioridade() == 3){
                ListaBaixaPrioridade.adicionarProcesso(ProcessoDesbloqueado);
            } else {
                System.out.println("Essa prioridade não existe");
            }
        }
    }
    public void AdicionarFilas(Processo processo){
        if (processo.getPrioridade() == 1){
            ListaAltaPrioridade.adicionarProcesso(processo);
        }
        else if(processo.getPrioridade() == 2){
            ListaMediaPrioridade.adicionarProcesso(processo);
        }
        else if(processo.getPrioridade() == 3){
            ListaBaixaPrioridade.adicionarProcesso(processo);
        } else {
            System.out.println("Prioridade não existente");
        }
    }
}
