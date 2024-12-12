package com.anuouan.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 
 * </p>
 *
 * @author anuouan
 * @since 2024-12-11
 */
@Getter
@Setter
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    private String username;

    private String password;
}
