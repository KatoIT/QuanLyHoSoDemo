package spring.spring.domain.response;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class GetObjectResponse<T> extends BaseResponse {
    private T item;
}
