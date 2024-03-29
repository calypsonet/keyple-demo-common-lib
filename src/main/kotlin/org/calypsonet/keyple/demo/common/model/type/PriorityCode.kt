/* **************************************************************************************
 * Copyright (c) 2022 Calypso Networks Association https://calypsonet.org/
 *
 * See the NOTICE file(s) distributed with this work for additional information
 * regarding copyright ownership.
 *
 * This program and the accompanying materials are made available under the terms of the
 * Eclipse Public License 2.0 which is available at http://www.eclipse.org/legal/epl-2.0
 *
 * SPDX-License-Identifier: EPL-2.0
 ************************************************************************************** */
package org.calypsonet.keyple.demo.common.model.type

enum class PriorityCode constructor(val key: Int, val value: String) {
  FORBIDDEN(0, "Forbidden (present in clean records only)"),
  SEASON_PASS(1, "Season Pass"),
  MULTI_TRIP(2, "Multi-trip ticket"),
  STORED_VALUE(3, "Stored Value"),
  EXPIRED(31, "Expired"),
  UNKNOWN(-1, "Unknown");

  companion object {
    fun findEnumByKey(key: Int): PriorityCode {
      for (contractPriority in values()) {
        if (contractPriority.key == key) {
          return contractPriority
        }
      }
      return UNKNOWN
    }
  }
}
