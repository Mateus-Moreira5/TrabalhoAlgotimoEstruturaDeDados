public class Schedule {
    private int CountCiclosAltaPrioridade = 0;
    ListaDeProcessos ListaAltaPrioridade = new ListaDeProcessos();
    ListaDeProcessos ListaMediaPrioridade = new ListaDeProcessos();
    ListaDeProcessos ListaBaixaPrioridade = new ListaDeProcessos();
    ListaDeProcessos ProcessosBloqueados = new ListaDeProcessos();

    public void executarCiclosDeCPU(){
        if(CountCiclosAltaPrioridade >= 5){
            if(ListaMediaPrioridade.listaVazia()){
                if(ListaBaixaPrioridade.listaVazia()){
                } else {
                    Processo ProcessoEmExecucao = ListaBaixaPrioridade.removerInicio();
                    if (ProcessoEmExecucao.getRecurso_necessario() != null && ProcessoEmExecucao.getRequisitou() == true){
                        ProcessosBloqueados.adicionarProcesso(ProcessoEmExecucao);
                        return;
                    } else {
                        System.out.println("|--------------------------------------|");
                        System.out.println("|Nome processo executado: "+ProcessoEmExecucao.getNome());
                        System.out.println("|ID do processo executado: "+ProcessoEmExecucao.getId());
                        System.out.println("|Prioridade do processo executado: "+ProcessoEmExecucao.getPrioridade());
                        System.out.println("|Quantidade de ciclos processo executado: "+ProcessoEmExecucao.getCiclos_necessarios());
                        System.out.println("Recurso necessário do processo executado: "+ProcessoEmExecucao.getRecurso_necessario());
                        System.out.println("|--------------------------------------|");
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
                if(ProcessoEmExecucao.getRecurso_necessario() != null && ProcessoEmExecucao.getRequisitou() == true){
                    ProcessosBloqueados.adicionarProcesso(ProcessoEmExecucao);
                    return;
                } else {
                    System.out.println("|--------------------------------------|");
                    System.out.println("|Nome processo executado: "+ProcessoEmExecucao.getNome());
                    System.out.println("|ID do processo executado: "+ProcessoEmExecucao.getId());
                    System.out.println("|Prioridade do processo executado: "+ProcessoEmExecucao.getPrioridade());
                    System.out.println("|Quantidade de ciclos processo executado: "+ProcessoEmExecucao.getCiclos_necessarios());
                    System.out.println("Recurso necessário do processo executado: "+ProcessoEmExecucao.getRecurso_necessario());
                    System.out.println("|--------------------------------------|");
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
                        if(ProcessoEmExecucao.getRecurso_necessario() != null && ProcessoEmExecucao.getRequisitou() == true){
                            ProcessosBloqueados.adicionarProcesso(ProcessoEmExecucao);
                            return;
                        } else {
                            System.out.println("|--------------------------------------|");
                            System.out.println("|Nome processo executado: "+ProcessoEmExecucao.getNome());
                            System.out.println("|ID do processo executado: "+ProcessoEmExecucao.getId());
                            System.out.println("|Prioridade do processo executado: "+ProcessoEmExecucao.getPrioridade());
                            System.out.println("|Quantidade de ciclos processo executado: "+ProcessoEmExecucao.getCiclos_necessarios());
                            System.out.println("Recurso necessário do processo executado: "+ProcessoEmExecucao.getRecurso_necessario());
                            System.out.println("|--------------------------------------|");
                            ProcessoEmExecucao.setCiclos_necessarios(ProcessoEmExecucao.getCiclos_necessarios()-1);
                            if(ProcessoEmExecucao.getCiclos_necessarios() > 0){
                                ListaBaixaPrioridade.adicionarProcesso(ProcessoEmExecucao);
                            } else {
                                System.out.println("Processo: "+ProcessoEmExecucao.getNome()+" Finalizado");
                            }
                        } 
                    }
                } else {
                    Processo ProcessoEmExecucao = ListaMediaPrioridade.removerInicio();
                    if(ProcessoEmExecucao.getRecurso_necessario() != null && ProcessoEmExecucao.getRequisitou() == true){
                        ProcessosBloqueados.adicionarProcesso(ProcessoEmExecucao);
                        return;
                    } else {
                        System.out.println("|--------------------------------------|");
                        System.out.println("|Nome processo executado: "+ProcessoEmExecucao.getNome());
                        System.out.println("|ID do processo executado: "+ProcessoEmExecucao.getId());
                        System.out.println("|Prioridade do processo executado: "+ProcessoEmExecucao.getPrioridade());
                        System.out.println("|Quantidade de ciclos processo executado: "+ProcessoEmExecucao.getCiclos_necessarios());
                        System.out.println("Recurso necessário do processo executado: "+ProcessoEmExecucao.getRecurso_necessario());
                        System.out.println("|--------------------------------------|");
                        ProcessoEmExecucao.setCiclos_necessarios(ProcessoEmExecucao.getCiclos_necessarios()-1);
                        if(ProcessoEmExecucao.getCiclos_necessarios() > 0){
                            ListaMediaPrioridade.adicionarProcesso(ProcessoEmExecucao);
                        } else {
                            System.out.println("Processo: "+ProcessoEmExecucao.getNome()+" Finalizado");
                        }
                    } 
                }
            } else {
                Processo ProcessoEmExecucao = ListaAltaPrioridade.removerInicio();
                if(ProcessoEmExecucao.getRecurso_necessario() != null && ProcessoEmExecucao.getRequisitou() == true){
                    ProcessosBloqueados.adicionarProcesso(ProcessoEmExecucao);
                    return;
                } else { 
                    System.out.println("|--------------------------------------|");
                    System.out.println("|Nome processo executado: "+ProcessoEmExecucao.getNome());
                    System.out.println("|ID do processo executado: "+ProcessoEmExecucao.getId());
                    System.out.println("|Prioridade do processo executado: "+ProcessoEmExecucao.getPrioridade());
                    System.out.println("|Quantidade de ciclos processo executado: "+ProcessoEmExecucao.getCiclos_necessarios());
                    System.out.println("Recurso necessário do processo executado: "+ProcessoEmExecucao.getRecurso_necessario());
                    System.out.println("|--------------------------------------|"); 
                    ProcessoEmExecucao.setCiclos_necessarios(ProcessoEmExecucao.getCiclos_necessarios()-1);
                    if(ProcessoEmExecucao.getCiclos_necessarios() > 0){
                        ListaAltaPrioridade.adicionarProcesso(ProcessoEmExecucao);
                        CountCiclosAltaPrioridade++;
                    } else {
                        System.out.println("Processo: "+ProcessoEmExecucao.getNome()+" Finalizado");
                    }
                }
            }
        }
    }
}
