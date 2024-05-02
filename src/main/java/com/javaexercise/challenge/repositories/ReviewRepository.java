package com.javaexercise.challenge.repositories;

import com.javaexercise.challenge.entities.Review;
import lombok.NonNull;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ReviewRepository extends JpaRepository<Review,Long> {

    String CACHE_NAME = "booksReviews";

    @NonNull
    @Cacheable(value = CACHE_NAME, key = "{'byId', #id}")
    @Override
    Optional<Review> findById(Long id);

    @Caching(
            evict = {
                    @CacheEvict(value = CACHE_NAME, key = "{'byId', #entity.id}"),
                    @CacheEvict(value = CACHE_NAME, key = "{'byBookId', #entity.bookId}"),
                    @CacheEvict(value = CACHE_NAME, key = "{'byUserId', #entity.userId}"),
            })
    @Override
    <S extends Review> S save(S entity);

    @NonNull
    @CacheEvict(cacheNames = CACHE_NAME, allEntries = true)
    @Override
    <S extends Review> List<S> saveAll(Iterable<S> entities);

    @Caching(
            evict = {
                    @CacheEvict(value = CACHE_NAME, key = "{'byId', #entity.id}"),
                    @CacheEvict(value = CACHE_NAME, key = "{'byBookId', #entity.bookId}"),
                    @CacheEvict(value = CACHE_NAME, key = "{'byUserId', #entity.userId}"),
            })
    @Override
    void delete(Review entity);

    @CacheEvict(cacheNames = CACHE_NAME, allEntries = true)
    @Override
    void deleteAll();

    @Cacheable(value = CACHE_NAME, key = "{'byBookId', #bookId}")
    List<Review> findByBookId(Long bookId);

    @Cacheable(value = CACHE_NAME, key = "{'byUserId', #userId}")
    List<Review> findByUserId(Long userId);
}
