package demo.walter.projectsapp.adapters.repository;

public interface RepositoryCallback<T> {

    void onSuccess(T result);
    void onError(Exception e);
}
