package io.github.LuizHenriqueMaronezi.pedidosapi.exceptions;

import java.time.Instant;

public record StandardError(
        Instant timeStamp,
        Integer status,
        String msg,
        String path
) { }
