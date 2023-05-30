package spring.spring.domain.response;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
public class GetListResponse<T> extends BaseResponse {
    private List<T> items;
    private long total = 0;
}
