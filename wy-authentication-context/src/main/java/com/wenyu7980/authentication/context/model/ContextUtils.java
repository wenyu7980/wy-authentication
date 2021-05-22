package com.wenyu7980.authentication.context.model;

import java.util.Objects;
import java.util.function.Supplier;

/**
 *
 * @author wenyu
 */
public class ContextUtils {
    private static final ThreadLocal<ContextInfo> LOCALS = new InheritableThreadLocal<>();

    public static void set(ContextInfo info) {
        LOCALS.set(info);
    }

    public static void remove() {
        LOCALS.remove();
    }

    public static String userId() {
        return LOCALS.get() == null ? null : LOCALS.get().getUserId();
    }

    public static void initSystem() {
        LOCALS.set(new ContextInfo(ContextConstants.SYSTEM_SCRIPT_USER_ID));
    }

    public static ContextInfo get() {
        ContextInfo contextInfo = LOCALS.get();
        if (contextInfo != null) {
            return contextInfo;
        }
        return LOCALS.get();
    }

    public static ContextInfo orElse(ContextInfo other) {
        ContextInfo contextInfo = LOCALS.get();
        return contextInfo != null ? contextInfo : other;
    }

    public static <X extends Throwable> ContextInfo orElseThrow(Supplier<? extends X> exceptionSupplier) throws X {
        ContextInfo contextInfo = LOCALS.get();
        if (contextInfo != null) {
            return contextInfo;
        } else {
            throw exceptionSupplier.get();
        }
    }

    public static boolean isPresent() {
        return LOCALS.get() != null;
    }

    public static boolean isSystemScript() {
        return LOCALS.get() != null && Objects.equals(LOCALS.get().getUserId(), ContextConstants.SYSTEM_SCRIPT_USER_ID);
    }
}
