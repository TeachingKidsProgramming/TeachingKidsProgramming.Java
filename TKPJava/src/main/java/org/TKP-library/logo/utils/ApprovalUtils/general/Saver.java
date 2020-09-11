package logo.utils.AprovalUtils;

public interface Saver<T> {
    public T save(T save) throws SavingException;
}

