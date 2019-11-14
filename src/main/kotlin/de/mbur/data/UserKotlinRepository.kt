package de.mbur.data

import org.springframework.data.jpa.repository.JpaRepository
import java.io.Serializable

interface UserKotlinRepository : JpaRepository<UserKotlin, Serializable>