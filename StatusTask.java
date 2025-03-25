public enum StatusTask {
    PENDENTE("Pendente"), EM_ANDAMENTO("Em andamento"), CONCLUIDA("Concluída");

    private final String status;
    StatusTask(String status) {
        this.status = status;
    }

    public String getStatus(){
        return status;
    }
}
