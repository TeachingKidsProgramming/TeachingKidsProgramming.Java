package src.main.java.org.teachingextentions.logo.utils.ApprovalUtils.general;


public interface Saver<T> {
    public T save(T save) throws SavingException;
}

