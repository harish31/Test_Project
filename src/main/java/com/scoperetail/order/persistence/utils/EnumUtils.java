package com.scoperetail.order.persistence.utils;

import com.scoperetail.order.persistence.entity.StaticData;

/** Utility methods for enums implementing {@link StaticData} interface */
public class EnumUtils {

  private EnumUtils() {}

  /**
   * Find enum type by {@link StaticData#getCode()}
   *
   * @param enumType
   * @param code
   * @param <T>
   * @return
   */
  public static <T extends Enum<T>> T findEnumType(final Class<T> enumType, final int code) {
    T returnValue = null;
    for (T c : enumType.getEnumConstants()) {
      if (((StaticData) c).getCode() == code) {
        returnValue = c;
        break;
      }
    }

    return returnValue;
  }
  /**
   * Find enum type by {@link StaticData#getLabel()}
   *
   * @param enumType
   * @param label
   * @param <T>
   * @return
   */
  public static <T extends Enum<T>> T findEnumType(final Class<T> enumType, final String label) {
    T returnValue = null;
    for (T c : enumType.getEnumConstants()) {
      if (((StaticData) c).getLabel() == label) {
        returnValue = c;
        break;
      }
    }
    return returnValue;
  }
}
