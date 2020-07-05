package taskmanager.database.common;

import graphql.ErrorType;
import graphql.ExceptionWhileDataFetching;
import graphql.GraphQLError;
import graphql.language.SourceLocation;
import graphql.servlet.GraphQLErrorHandler;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Slf4j
@Component
public class CustomGraphQLErrorHandler implements GraphQLErrorHandler {

    @Override
    public List<GraphQLError> processErrors(List<GraphQLError> errors) {
        List<GraphQLError> errorOutput = new ArrayList<>();

        errorOutput.addAll(filterClientErrors(errors));
        errorOutput.addAll(filterServerErrors(errors));

        return errorOutput;
    }

    private List<GraphQLError> filterClientErrors(List<GraphQLError> errors) {
        return errors.stream()
                .filter(this::isClientError)
                .collect(Collectors.toList());
    }

    private boolean isClientError(GraphQLError error) {
        return !(error instanceof ExceptionWhileDataFetching || error instanceof Throwable);
    }

    private List<GraphQLError> filterServerErrors(List<GraphQLError> errors) {
        return errors.stream()
                .filter(this::isServerError)
                .map(GraphQLErrorAdapter::new)
                .collect(Collectors.toList());
    }

    private boolean isServerError(GraphQLError error) {
        return error instanceof ExceptionWhileDataFetching || error instanceof Throwable;
    }

    @RequiredArgsConstructor
    private static class GraphQLErrorAdapter implements GraphQLError {

        private final GraphQLError error;

        @Override
        public String getMessage() {
            return (error instanceof ExceptionWhileDataFetching) ?
                    ((ExceptionWhileDataFetching) error).getException().getMessage() : error.getMessage();
        }

        @Override
        public List<SourceLocation> getLocations() {
            return error.getLocations();
        }

        @Override
        public ErrorType getErrorType() {
            return error.getErrorType();
        }

        @Override
        public List<Object> getPath() {
            return error.getPath();
        }

        @Override
        public Map<String, Object> toSpecification() {
            return error.toSpecification();
        }

        @Override
        public Map<String, Object> getExtensions() {
            return error.getExtensions();
        }

    }

}
