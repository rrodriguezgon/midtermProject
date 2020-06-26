/**
 *
 */
package com.ironhack.midtermProject.repository;

import com.ironhack.midtermProject.model.entities.Transfer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 */
@Repository
public interface TranferRepository extends JpaRepository<Transfer,Integer> {

    /**
     *
     * @param accountId
     * @return
     */
    @Query(value = "SELECT MAX(count) FROM (SELECT date_transfer, COUNT(*) AS count FROM transfer\n" +
            "WHERE emitteraccount_id = :accountId\n" +
            "GROUP BY DATE(date_transfer)) results",
    nativeQuery = true)
    public Integer getMaxTransactionsAccount(@Param("accountId") Integer accountId);

    /**
     *
     * @param accountId
     * @return
     */
    @Query(value="SELECT COUNT(*) FROM transfer\n" +
            "WHERE DATE(date_transfer) = utc_date()\n" +
            "AND emitteraccount_id = :accountId",
    nativeQuery = true)
    public Integer getNumberTransactionsAccountDay(@Param("accountId") Integer accountId);

    /**
     *
     * @param accountId
     * @return
     */
    @Query(value="SELECT COUNT(*) FROM transfer\n" +
            " WHERE emitteraccount_id = :accountId\n" +
            " AND DATE(date_transfer) = DATE(UTC_DATE())\n" +
            " AND HOUR(date_transfer) = HOUR(UTC_DATE())\n" +
            " AND MINUTE(date_transfer) = MINUTE(UTC_DATE())\n" +
            " GROUP BY SECOND(date_transfer);",
            nativeQuery = true)
    public Integer getNumberTransactionsAccountSecond(@Param("accountId") Integer accountId);
}
