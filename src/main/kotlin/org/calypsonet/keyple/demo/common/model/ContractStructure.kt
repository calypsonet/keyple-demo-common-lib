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
package org.calypsonet.keyple.demo.common.model

import java.io.Serializable
import org.calypsonet.keyple.demo.common.model.type.DateCompact
import org.calypsonet.keyple.demo.common.model.type.PriorityCode
import org.calypsonet.keyple.demo.common.model.type.VersionNumber

data class ContractStructure(
    var contractVersionNumber: VersionNumber,
    var contractTariff: PriorityCode,
    var contractSaleDate: DateCompact,
    var contractValidityEndDate: DateCompact,
    var contractSaleSam: Int?,
    var contractSaleCounter: Int?,
    var contractAuthKvc: Int?,
    var contractAuthenticator: Int?
) : Serializable {
  var counterValue: Int? = null
}
