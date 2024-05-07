package utils;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class CollectionUtilsTest {

    @Test
    void isEmpty() {
        assertThat(CollectionUtils.isEmpty(null)).isTrue();
        assertThat(CollectionUtils.isEmpty(List.of())).isTrue();
        assertThat(CollectionUtils.isEmpty(Set.of())).isTrue();

        assertThat(CollectionUtils.isEmpty(List.of(new Object()))).isFalse();
        assertThat(CollectionUtils.isEmpty(Set.of(new Object()))).isFalse();
    }

}