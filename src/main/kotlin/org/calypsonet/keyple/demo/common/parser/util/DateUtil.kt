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
package org.calypsonet.keyple.demo.common.parser.util

import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*
import java.util.Calendar.HOUR_OF_DAY
import java.util.Calendar.MILLISECOND
import java.util.Calendar.MINUTE
import java.util.Calendar.SECOND

object DateUtil {

  const val DATE_01_01_1997 = "01/01/1997"
  const val DATE_01_01_2010 = "01/01/2010"
  const val DD_MM_YYYY = "dd/MM/yyyy"
  const val DD_MMMM_YYYY = "dd MMMM yyyy"
  const val yyyy_MM_dd_HH_mm_ss = "yyyy-MM-dd'T'HH:mm:ss"
  const val DATE_FORMAT_DISPLAY = "dd MMMM yyyy, HH:mm"

  const val MILLIS_PER_DAY = 1000 * 60 * 60 * 24
  const val MILLIS_PER_MINUTE = 60 * 24

  fun formatDateDisplayedContract(date: Date): String {
    val sdf = SimpleDateFormat(DD_MMMM_YYYY, Locale.getDefault())
    return sdf.format(date)
  }

  fun parseDate(date: String): Date {
    val sdf = SimpleDateFormat(DD_MM_YYYY)
    return sdf.parse(date)!!
  }

  fun formatDateToDisplay(date: Date): String {
    val df: DateFormat = SimpleDateFormat(DD_MM_YYYY)
    return df.format(date)
  }

  fun formatDateToDisplayWithHour(date: Date): String {
    val df: DateFormat = SimpleDateFormat(DATE_FORMAT_DISPLAY, Locale.getDefault())
    return df.format(date)
  }

  /**
   * Parse a date stamp using the number of days since [startDate](being date 0).
   *
   * @param dateContent number of days since [startDate]
   * @param startDate Date in format dd/MM/yyyy
   *
   * @return [Date]
   */
  fun parseDateStamp(dateContent: Int, startDate: String): Date {
    val sdf = SimpleDateFormat(DD_MM_YYYY)
    val calendar: Calendar = Calendar.getInstance()
    @Suppress("NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")
    calendar.time = sdf.parse(startDate)
    calendar.add(Calendar.DATE, dateContent)
    return calendar.time
  }

  /**
   * Parse a time stamp using the number of minutes since [startDate].
   *
   * @param minutesContent number of minutes since [startDate]
   * @param startDate Date in format dd/MM/yyyy
   *
   * @return [Date]
   */
  fun parseTimeStamp(minutesContent: Int, startDate: String): Date {
    val sdf = SimpleDateFormat(DD_MM_YYYY)
    val calendar: Calendar = Calendar.getInstance()
    @Suppress("NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")
    calendar.time = sdf.parse(startDate)
    calendar.add(MINUTE, minutesContent)
    return calendar.time
  }

  fun dateToDateCompact(date: Date): Int {
    val calendar = Calendar.getInstance()
    calendar.set(2010, 0, 1, 0, 0, 0)
    calendar.set(MILLISECOND, 0)
    val startDate = calendar.time
    return getDaysDifference(startDate, date)
  }

  private fun getDaysDifference(fromDate: Date?, toDate: Date?): Int {
    return if (fromDate == null || toDate == null) {
      0
    } else {
      val diff = toDate.time - fromDate.time
      return (diff / MILLIS_PER_DAY).toInt()
    }
  }

  fun dateToTimeCompact(date: Date): Int {
    val calendar = Calendar.getInstance()
    calendar.time = date
    calendar.set(HOUR_OF_DAY, 0)
    calendar.set(MINUTE, 0)
    calendar.set(SECOND, 0)
    calendar.set(MILLISECOND, 0)
    val startDate = calendar.time
    return getHoursDifference(startDate, date)
  }

  private fun getHoursDifference(fromDate: Date?, toDate: Date?): Int {
    return if (fromDate == null || toDate == null) {
      0
    } else {
      val diff = toDate.time - fromDate.time
      return (diff / (1000 * 60)).toInt()
    }
  }
}
