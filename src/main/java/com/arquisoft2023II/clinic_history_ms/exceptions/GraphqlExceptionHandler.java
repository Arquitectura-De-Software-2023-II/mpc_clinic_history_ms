package com.arquisoft2023II.clinic_history_ms.exceptions;

import graphql.ErrorType;
import graphql.GraphQLError;
import graphql.GraphqlErrorBuilder;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.graphql.execution.DataFetcherExceptionResolverAdapter;
import org.springframework.stereotype.Component;


@Component
public class GraphqlExceptionHandler extends DataFetcherExceptionResolverAdapter {

    @Override
    protected GraphQLError resolveToSingleError(Throwable ex, DataFetchingEnvironment env) {
        System.out.println(ErrorType.ValidationError);
        System.out.println(ErrorType.ExecutionAborted);
        System.out.println(ErrorType.InvalidSyntax);
        System.out.println(ErrorType.DataFetchingException);
        System.out.println(ErrorType.NullValueInNonNullableField);
        System.out.println(ErrorType.OperationNotSupported);

        if (ex instanceof ValidationErrorException){
            return GraphqlErrorBuilder.newError()
                    .message(ex.getMessage())
                    .errorType(ErrorType.ValidationError)
                    .build();
        }else if (ex instanceof ExecutionAbortedException){
            return GraphqlErrorBuilder.newError()
                    .message(ex.getMessage())
                    .errorType(ErrorType.ExecutionAborted)
                    .build();
        } else if (ex instanceof InvalidSyntaxException){
            return GraphqlErrorBuilder.newError()
                    .message(ex.getMessage())
                    .errorType(ErrorType.InvalidSyntax)
                    .build();
        } else if (ex instanceof DataFetchingException){
            return GraphqlErrorBuilder.newError()
                    .message(ex.getMessage())
                    .errorType(ErrorType.DataFetchingException)
                    .build();
        } else if (ex instanceof NullValueInNonNullableFieldException){
            return GraphqlErrorBuilder.newError()
                    .message(ex.getMessage())
                    .errorType(ErrorType.NullValueInNonNullableField)
                    .build();
        } else if (ex instanceof OperationNotSuportException){
            return GraphqlErrorBuilder.newError()
                    .message(ex.getMessage())
                    .errorType(ErrorType.OperationNotSupported)
                    .build();
        }
        return GraphqlErrorBuilder.newError()
                .message(ex.getMessage())
                .errorType(ErrorType.ExecutionAborted)
                .build();

    }
}
